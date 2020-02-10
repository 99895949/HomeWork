<template>
  <div style="width:400px;margin-left:300px;">
    <el-form ref="form" label-width="80px">
      <el-form-item label="手机号">
        <el-input size="small" v-model="form.phone" placeholder="请输入手机号"></el-input>
      </el-form-item>
      <el-form-item label="金额">
        <el-input size="small" disabled v-model="form.balance"></el-input>
      </el-form-item>
      <el-form-item label="充值金额">
        <el-input size="small" v-model="form.money"></el-input>
      </el-form-item>
      <el-form-item label>
        <el-button style="margin-left:10px;" class="update-btn" type="primary" @click="doSearch">查询</el-button>
        <el-button style="margin-left:50px;" class="update-btn" type="warning" @click="doSubmit">充值</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { getByPhone, addMoney } from "@/api/card";

export default {
  data() {
    return {
      form: {
        phone: "",
        balance: "",
        money: null
      }
    };
  },
  methods: {
    cancel() {
      this.reset();
    },
    doSubmit() {
      let that = this;
      if (this.form.money == "" || this.form.money == null) {
        that.$alert("请输入充值金额", "提示");
        return;
      }
      addMoney(this.form.phone, this.form.money)
        .then(data => {
          that.$alert("充值成功", "提示");
          that.form.money = "";
          getByPhone(that.form.phone).then(data => {
            that.form.balance = data.cardBalance;
          });
        })
        .catch(e => {
          that.$alert("充值失败", "提示");
        });
    },
    doSearch() {
      let that = this;
      getByPhone(this.form.phone)
        .then(data => {
          if (data.cardBalance) {
            that.$alert("查询成功", "提示");
            that.form.balance = data.cardBalance;
          } else {
            that.$alert("没有查询到停车卡", "提示");
            that.form.balance = "";
          }
        })
        .catch(function(error) {
          that.$alert("没有查询到停车卡", "提示");
          that.form.balance = "";
        });
    }
  }
};
</script>
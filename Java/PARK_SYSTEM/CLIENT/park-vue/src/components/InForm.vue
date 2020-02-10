<template>
  <div>
    <el-dialog :title="isAdd ? '入场' : '出场'" :visible.sync="dialog">
      <el-form ref="form" label-width="100px">
        <el-form-item label="车牌号">
          <el-input :disabled="isAdd==false" size="small" v-model="form.carId" placeholder="请输入车牌号"></el-input>
        </el-form-item>
        <!-- <el-form-item v-if="isAdd==false" label="支付方式">
          <el-select v-model="form.payType" placeholder="请选择支付方式" style="width:100%;">
            <el-option
              v-for="item in payTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button class="update-btn" type="primary" @click="doSubmit">提交</el-button>
        <el-button class="update-btn" @click="cancel">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { add, update } from "@/api/info";

export default {
  props: {
    isAdd: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      form: {
        carId: "",
        infoId: "",
        payType: ""
      },
      dialog: false,
      payTypes: [
        { label: "现金支付", value: 1 },
        { label: "卡支付", value: 0 }
      ]
    };
  },
  methods: {
    cancel() {
      this.reset();
    },
    reset() {
      this.dialog = false;
      this.form = {
        carId: ""
      };
    },
    doSubmit() {
      if (this.isAdd) {
        this.add();
      } else {
        this.update();
      }
    },
    add() {
      let that = this;
      add(that.form.carId).then(data => {
        that.$parent.$alert("成功入场", "提示");
        that.$parent.getAll();
        that.reset();
      });
    },
    update() {
      let that = this;
      update(this.form.carId)
        .then(data => {
          if (data.payStatus == 1) {
            that.$parent.$alert("成功出场", "提示");
          } else {
            that.$parent.$alert("无卡或金额不足，请用现金支付", "提示");
          }
          that.$parent.getAll();
          that.reset();
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
};
</script>
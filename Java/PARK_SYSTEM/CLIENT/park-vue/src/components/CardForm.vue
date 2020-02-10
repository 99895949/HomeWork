<template>
  <div>
    <el-dialog :title="isAdd ? '新增停车卡' : '编辑停车卡'" :visible.sync="dialog">
      <el-form ref="form" :model="form" label-width="100px">
        <el-row>
          <el-col :span="12">
            <div class="btn-group">
              <el-form-item label="停车卡号" prop="cardId">
                <el-input size="small" v-model="form.cardId" placeholder="请输入停车卡号"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="btn-group">
              <el-form-item label="停车卡类型" prop="cardType">
                <el-select v-model="form.cardType" placeholder="请选择车位类型" style="width:100%;">
                  <el-option
                    v-for="item in cardTypes"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                  ></el-option>
                </el-select>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <div class="btn-group">
              <el-form-item label="用户姓名" prop="userName">
                <el-input size="small" v-model="form.userName" placeholder="请输入用户姓名"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="btn-group">
              <el-form-item label="卡密码" prop="userPassword">
                <el-input size="small" v-model="form.userPassword" placeholder="请输入卡密码"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <div class="btn-group">
              <el-form-item label="用户电话" prop="userPhone">
                <el-input size="small" v-model="form.userPhone" placeholder="请输入用户电话"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="btn-group">
              <el-form-item label="余额" prop="cardBalance">
                <el-input size="small" v-model="form.cardBalance" placeholder="请输入卡片余额"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <div class="btn-group">
              <el-form-item label="绑定车牌号" prop="carIds">
                <el-input
                  v-for="(item,index) in carIds"
                  :key="index"
                  size="small"
                  v-model="carIds[index]"
                  placeholder="请输入车牌号"
                ></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="btn-group">
              <el-button type="primary" @click="addItem">增加</el-button>
              <el-button type="primary" @click="removeItem">删除</el-button>
            </div>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button class="update-btn" type="primary" @click="doSubmit">提交</el-button>
        <el-button class="update-btn" @click="cancel">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { addAll, updateAll } from "@/api/card";

export default {
  props: {
    isAdd: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      cardTypes: [
        { label: "普通卡", value: 0 },
        { label: "VIP", value: 1 }
      ],
      form: {
        cardId: "",
        userName: "",
        userPassword: "",
        userPhone: "",
        cardType: 0,
        cardBalance: 50.0
      },
      dialog: false,
      carIds: [""]
    };
  },
  methods: {
    addItem() {
      let carIds = this.carIds;
      carIds.push("");
    },
    removeItem() {
      let carIds = this.carIds;
      if (carIds.length > 1) {
        carIds.pop();
      }
    },
    cancel() {
      this.reset();
    },
    reset() {
      this.dialog = false;
      this.form = {
        cardId: "",
        userName: "",
        userPassword: "",
        userPhone: "",
        cardType: 0,
        cardBalance: 50.0
      };
      this.carIds = [""];
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
      addAll(this.form, this.carIds).then(data => {
        that.$parent.$alert("添加成功", "提示");
        that.reset();
        that.$parent.getAll();
      });
    },
    update() {
      let that = this;
      updateAll(this.form, this.carIds).then(data => {
        that.$parent.$alert("修改成功", "提示");
        that.$parent.getAll();
        that.reset();
      });
    }
  }
};
</script>
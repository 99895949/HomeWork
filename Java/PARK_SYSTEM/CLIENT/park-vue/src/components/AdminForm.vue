<template>
  <div>
    <el-dialog :title="isAdd ? '新增管理员' : '编辑管理员'" :visible.sync="dialog">
      <el-form ref="adminForm" :model="admin" :rules="admin_rules" label-width="100px">
        <el-form-item label="用户名" prop="adminName">
          <el-input
            size="small"
            v-model="admin.adminName"
            placeholder="请输入用户名"
            :disabled="isAdd == false"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="adminPassword">
          <el-input size="small" v-model="admin.adminPassword" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="adminGender">
          <el-select v-model="admin.adminGender" placeholder="请选择性别" style="width:100%;">
            <el-option key="男" label="男" value="男"></el-option>
            <el-option key="女" label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="联系方式" prop="adminPhone">
          <el-input size="small" v-model="admin.adminPhone" placeholder="请输入联系方式"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="adminEmail">
          <el-input size="small" v-model="admin.adminEmail" placeholder="请输入邮箱"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="adminAddress">
          <el-input size="small" v-model="admin.adminAddress" placeholder="请输入地址"></el-input>
        </el-form-item>
        <el-form-item label="角色" prop="adminType">
          <el-select v-model="admin.adminType" placeholder="请选择角色" style="width:100%;">
            <el-option key="1" label="管理员" value="1"></el-option>
            <el-option key="0" label="操作员" value="0"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button class="update-btn" type="primary" @click="doSubmit">提交</el-button>
        <el-button class="update-btn" @click="cancel">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { add, update } from "@/api/admin";

export default {
  props: {
    isAdd: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      admin: {
        adminId: null,
        adminName: "",
        adminPassword: "",
        adminGender: "",
        adminPhone: "",
        adminEmail: "",
        adminAddress: "",
        adminType: null
      },
      admin_rules: {
        adminName: [
          { required: true, message: "请输入用户名", trigger: "blur" }
        ],
        adminPassword: [
          { required: true, message: "请输入密码", trigger: "blur" }
        ],
        adminPhone: [
          { required: true, message: "请输入联系方式", trigger: "blur" }
        ]
      },
      dialog: false
    };
  },
  methods: {
    cancel() {
      this.reset();
    },
    reset() {
      this.dialog = false;
      this.admin = {
        adminId: null,
        adminName: "",
        adminPassword: "",
        adminGender: "",
        adminPhone: "",
        adminEmail: "",
        adminAddress: "",
        adminType: null
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
      add(this.admin)
        .then(data => {
          that.$parent.$alert("添加成功", "提示");
          that.reset();
          that.$parent.getAllAdmin();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    update() {
      let that = this;
      update(this.admin)
        .then(data => {
          that.$parent.$alert("修改成功", "提示");
          that.$parent.getAllAdmin();
          that.reset();
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
};
</script>
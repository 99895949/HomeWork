<template>
  <div>
    <el-form ref="loginForm" :model="form" :rules="rules" label-width="80px" class="login-box">
      <h3 class="login-title">欢迎登录</h3>
      <el-form-item label="账号" prop="adminName">
        <el-input type="text" placeholder="请输入账号" v-model="form.adminName" />
      </el-form-item>
      <el-form-item label="密码" prop="adminPassword">
        <el-input type="password" placeholder="请输入密码" v-model="form.adminPassword" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" v-on:click="onSubmit('loginForm')">登录</el-button>
        <el-button type="info" v-on:click="reset('loginForm')">重置</el-button>
      </el-form-item>
    </el-form>

    <el-dialog title="温馨提示" :visible.sync="dialogVisible" width="30%">
      <span>请输入账号和密码</span>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { getAll } from "@/api/permission";
import { login } from "@/api/admin";
export default {
  name: "Login",
  created() {
    var that = this;
    document.onkeydown = function(e) {
      var key = window.event.keyCode;
      if (key == 13) {
        that.onSubmit("loginForm");
      }
    };
  },
  data() {
    return {
      form: {
        adminName: "",
        adminPassword: ""
      },

      // 表单验证，需要在 el-form-item 元素中增加 prop 属性
      rules: {
        adminName: [
          { required: true, message: "账号不可为空", trigger: "blur" }
        ],
        adminPassword: [
          { required: true, message: "密码不可为空", trigger: "blur" }
        ]
      },

      // 对话框显示和隐藏
      dialogVisible: false
    };
  },
  methods: {
    reset(formName) {
      this.form = {
        adminName: "",
        adminPassword: ""
      };
      // 清除表单校验的提示
      if (this.$refs[formName]) {
        // 延时执行
        this.$nextTick(function() {
          this.$refs[formName].clearValidate();
        });
      }
    },
    onSubmit(formName) {
      let that = this;
      // 为表单绑定验证功能
      this.$refs[formName].validate(valid => {
        if (valid) {
          login(that.form).then(data => {
            if (data) {
              console.log(data);
              sessionStorage.removeItem("user");
              let user = data;
              sessionStorage.setItem("user", JSON.stringify(user));
              // 使用 vue-router 路由到指定页面，该方式称之为编程式导航
              this.$router.push("/home");
            } else {
              alert("用户名或密码错误");
            }
          });
        } else {
          this.dialogVisible = true;
          return false;
        }
      });
    }
  }
};
</script>

<style scoped>
.login-box {
  border: 1px solid #dcdfe6;
  width: 350px;
  margin: 180px auto;
  padding: 35px 35px 15px 35px;
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  box-shadow: 0 0 25px #909399;
}

.login-title {
  text-align: center;
  margin: 0 auto 40px auto;
  color: #303133;
}
</style>
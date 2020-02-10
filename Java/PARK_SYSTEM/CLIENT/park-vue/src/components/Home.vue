<template>
  <el-container style="height: 500px;border: 1px solid #eee">
    <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
        <i class="el-icon-user" style="margin-right: 15px">
          <span>{{adminName}}</span>
        </i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>
            <span @click="logout()">注销</span>
          </el-dropdown-item>
          <!-- <el-dropdown-item>
            <span @click="logout()">个人信息</span>
          </el-dropdown-item> -->
        </el-dropdown-menu>
      </el-dropdown>
    </el-header>
    <el-container>
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu default-active="1" @open="handleOpen" @close="handleClose" unique-opened router>
          <el-submenu index="1" v-if="checkPermission(['admin','root'])">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>后台人员管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item v-if="checkPermission(['root'])" index="/Admin">管理员管理</el-menu-item>
              <el-menu-item v-if="checkPermission(['admin','root'])" index="/Operator">操作员管理</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2" v-if="checkPermission(['operator','admin','root'])">
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span>停车卡管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/Card">停车卡汇总</el-menu-item>
              <el-menu-item index="/CardMoney">停车卡充值</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="3" v-if="checkPermission(['operator','admin','root'])">
            <template slot="title">
              <i class="el-icon-document"></i>
              <span>停车位管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/Station" v-if="checkPermission(['admin','root'])">车位汇总</el-menu-item>
              <el-menu-item
                index="/FreeStation"
                v-if="checkPermission(['operator','admin','root'])"
              >空闲车位统计</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="4" v-if="checkPermission(['admin','root'])">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span>停车费管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/Charge">收费规则</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="5" v-if="checkPermission(['operator','admin','root'])">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span>车辆出入管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/info">日志汇总</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import { checkPermission, getSessionItem } from "@/utils/permission";

export default {
  data() {
    return {
      adminName: null
    };
  },
  mounted() {
    this.adminName = getSessionItem("user").adminName;
  },
  methods: {
    checkPermission,
    logout() {
      sessionStorage.removeItem("user");
      this.$router.push("/login");
    },
    handleOpen(key, keyPath) {},
    handleClose(key, keyPath) {}
  }
};
</script>

<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>

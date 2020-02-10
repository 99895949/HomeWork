<template>
  <div>
    <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
      <el-menu
        :default-active="$route.path"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
        router
      >
        <el-submenu index="1">
          <template slot="title">用户管理</template>
          <el-menu-item index="/Reader">读者管理</el-menu-item>
          <el-menu-item index="/ReaderType">读者类别管理</el-menu-item>
          <el-menu-item index="/Admin">管理员管理</el-menu-item>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">图书管理</template>
          <el-menu-item index="/Category">类别管理</el-menu-item>
          <el-menu-item index="/Book">图书总览</el-menu-item>
        </el-submenu>
        <el-menu-item index="/Info">日志管理</el-menu-item>
      </el-menu>
    </el-col>
  </div>
</template>
<script type="text/ecmascript-6">
export default {
  data() {
    return {};
  },

  methods: {
    handleSelect(key, keypath) {
      console.log(key, keypath);
    }
  }
};
</script>
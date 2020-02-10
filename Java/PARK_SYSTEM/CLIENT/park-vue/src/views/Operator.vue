<template>
  <div>
    <el-row>
      <el-col :span="24">
        <div class="btn-group">
          <el-button type="primary" @click="toAdd()">新增</el-button>
        </div>
      </el-col>
    </el-row>
    <div>
      <el-table :data="admins" border style="width: 100%;">
        <el-table-column fixed prop="adminName" label="用户名"></el-table-column>
        <el-table-column prop="adminPassword" label="密码"></el-table-column>
        <el-table-column prop="adminGender" label="性别" width="50"></el-table-column>
        <el-table-column prop="adminPhone" label="电话"></el-table-column>
        <el-table-column prop="adminEmail" label="邮箱"></el-table-column>
        <el-table-column prop="adminAddress" label="地址"></el-table-column>
        <el-table-column prop="adminType" label="角色">操作员</el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button
              @click="toEdit(scope.row)"
              type="primary"
              icon="el-icon-edit"
              size="small"
              circle
            ></el-button>
            <el-button
              @click="remove(scope.row)"
              type="danger"
              icon="el-icon-delete"
              size="small"
              circle
            ></el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <AdminForm ref="adminform" :is-add="isAdd"></AdminForm>
  </div>
</template>

<script>
import { getAllOperators, remove } from "@/api/admin";
import AdminForm from "@/components/AdminForm";
export default {
  components: {
    AdminForm
  },
  methods: {
    toEdit(row) {
      this.isAdd = false;
      // 这里获取到了子组件，要传值可以直接通过这个指针
      const _this = this.$refs.adminform;
      _this.dialog = true;
      let temp =  JSON.parse(JSON.stringify(row));
      temp.adminType = temp.adminType == 1 ? "管理员":"操作员";
      _this.admin = temp;
    },
    toAdd() {
      this.isAdd = true;
      const _this = this.$refs.adminform;
      _this.dialog = true;
    },
    remove(row) {
      let that = this;
      this.$confirm("此操作将删除该管理员, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        remove(row).then(res => {
          that.$parent.$alert("删除成功", "提示");
          that.getAllAdmin();
        });
      });
    },
    getAllAdmin() {
      let that = this;
      getAllOperators().then(data => {
        that.admins = data;
      });
    }
  },

  data() {
    return {
      isAdd: true,
      admins: []
    };
  },
  mounted() {
    this.getAllAdmin();
  }
};
</script>
<style>
.btn-group{
  display: flex;
  margin-left: 5px;
}
.el-table{
  margin-left: 5px;
}
.el-table td {
  padding: 0.01 0px;
}
.el-table th {
  padding: 0px;
}
</style>
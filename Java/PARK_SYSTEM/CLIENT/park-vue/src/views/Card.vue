<template>
  <div>
    <el-row>
      <el-col :span="24">
        <div class="btn-group">
          <el-button type="primary" @click="toAdd()">新增</el-button>
          <div style="width:200px;margin-left:20px;">
            <el-input v-model="phone" placeholder="预留手机号"></el-input>
          </div>
          <el-button type="danger" @click="toSearch()">查找</el-button>
        </div>
      </el-col>
    </el-row>
    <div>
      <el-table :data="data" border style="width: 100%;">
        <el-table-column prop="cardId" label="停车卡号"></el-table-column>
        <el-table-column fixed prop="cardType" label="停车卡类型">
          <template slot-scope="scope">
            <span v-if="scope.row.cardType == 0">普通卡</span>
            <span v-else-if="scope.row.cardType == 1">VIP</span>
          </template>
        </el-table-column>
        <el-table-column prop="userName" label="用户姓名"></el-table-column>
        <el-table-column prop="userPassword" label="卡密码"></el-table-column>
        <el-table-column prop="userPhone" label="用户电话"></el-table-column>
        <el-table-column prop="cardBalance" width="50" label="余额"></el-table-column>
        <el-table-column prop="cars" :formatter="formatter" label="车牌号"></el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="100"
          v-if="checkPermission(['admin','root'])"
        >
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
      <nav style="text-align: center">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :page-sizes="page_sizes"
          layout="total, sizes, prev, pager, next"
          :current-page="currentPage"
          :page-size="pageSize"
          :total="totalElements"
        ></el-pagination>
      </nav>
    </div>
    <CardForm ref="form" :is-add="isAdd"></CardForm>
  </div>
</template>

<script>
import { getAll, remove } from "@/api/card";
import CardForm from "@/components/CardForm";
import { checkPermission, getSessionItem } from "@/utils/permission";
export default {
  components: {
    CardForm
  },
  methods: {
    checkPermission,
    formatter(row, column, cellValue, index) {
      return cellValue.map(e => e.carId).join(",");
    },
    toSearch() {
      let that = this;
      that.currentPage = 1;
      that.search = that.phone;
      getAll(that.currentPage - 1, that.pageSize, that.search).then(data => {
        that.data = data.content;
        that.totalPages = data.totalPages;
        that.totalElements = data.totalElements;
      });
    },
    handleSizeChange(val) {
      let that = this;
      that.pageSize = val;
      that.currentPage = 1;
      getAll(that.currentPage - 1, that.pageSize, that.search).then(data => {
        that.data = data.content;
        that.totalPages = data.totalPages;
        that.totalElements = data.totalElements;
      });
    },
    handleCurrentChange(val) {
      let that = this;
      that.currentPage = val;
      getAll(that.currentPage - 1, that.pageSize, that.search).then(data => {
        that.data = data.content;
        that.totalPages = data.totalPages;
        that.totalElements = data.totalElements;
      });
    },
    toAdd() {
      this.isAdd = true;
      const _this = this.$refs.form;
      _this.dialog = true;
    },
    toEdit(row) {
      this.isAdd = false;
      // 这里获取到了子组件，要传值可以直接通过这个指针
      const _this = this.$refs.form;
      _this.dialog = true;
      let temp = JSON.parse(JSON.stringify(row));
      let carIds = [];
      row.cars.forEach(car => {
        carIds.push(car.carId);
      });
      console.log(row);
      _this.carIds = carIds;
      _this.form = temp;
    },
    remove(row) {
      let that = this;
      this.$confirm("此操作将删除该信息, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        remove(row).then(res => {
          that.$parent.$alert("删除成功", "提示");
          that.getAll();
        });
      });
    },
    getAll() {
      let that = this;
      getAll(that.currentPage - 1, that.pageSize, that.search).then(data => {
        that.data = data.content;
        that.totalPages = data.totalPages;
        that.totalElements = data.totalElements;
        that.totalElements = data.totalElements;
      });
    }
  },

  data() {
    return {
      phone: "",
      search:"",
      currentPage: 1,
      pageSize: 5,
      totalPages: 0,
      totalElements: 0,
      page_sizes: [5, 10, 15],
      isAdd: true,
      data: [],
      carIds: [""]
    };
  },
  mounted() {
    this.getAll();
  }
};
</script>
<style>
.btn-group {
  display: flex;
  margin-left: 5px;
}
.el-table {
  margin-left: 5px;
}
.el-table td {
  padding: 0.01 0px;
}
.el-table th {
  padding: 0px;
}
</style>
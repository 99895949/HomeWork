<template>
  <div>
    <el-row>
      <el-col :span="24">
        <div class="btn-group">
          <el-button type="primary" @click="toAdd()">入场</el-button>
          <div style="width:200px;margin-left:20px;">
            <el-input v-model="carId" placeholder="车牌号"></el-input>
          </div>
          <el-button type="danger" @click="toSearch()">查找</el-button>
        </div>
      </el-col>
    </el-row>
    <div>
      <el-table :data="data" border style="width: 100%;">
        <el-table-column prop="carId" label="车牌号"></el-table-column>
        <el-table-column prop="stationLocation" label="车位" width="50"></el-table-column>
        <el-table-column prop="cardId" label="停车卡号"></el-table-column>
        <el-table-column prop="userName" label="用户姓名"></el-table-column>
        <el-table-column prop="beginTimeStr" label="开始时间" width="180"></el-table-column>
        <el-table-column prop="endTimeStr" label="结束时间" width="180"></el-table-column>
        <el-table-column prop="payType" label="支付方式">
          <template slot-scope="scope">
            <span v-if="scope.row.payType == 0">停车卡支付</span>
            <span v-else-if="scope.row.payType == 1">现金支付</span>
          </template>
        </el-table-column>
        <el-table-column prop="payStatus" label="支付状态">
          <template slot-scope="scope">
            <span v-if="scope.row.payStatus == 0">等待支付</span>
            <span v-else-if="scope.row.payStatus == 1">支付成功</span>
          </template>
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="150"
          v-if="checkPermission(['operator','admin','root'])"
        >
          <template slot-scope="scope">
            <el-button
              v-if="scope.row.payStatus == 0 && scope.row.endTime == null"
              @click="toEdit(scope.row)"
              type="primary"
              size="small"
            >出场</el-button>
            <el-button
              v-if="scope.row.payStatus == 0 && scope.row.endTime != null"
              @click="submit(scope.row)"
              type="primary"
              size="small"
            >确认</el-button>
            <el-button
              v-if="checkPermission(['root'])"
              @click="remove(scope.row)"
              type="danger"
              size="small"
            >删除</el-button>
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
    <InForm ref="form" :is-add="isAdd"></InForm>
  </div>
</template>

<script>
import { getAll, remove, finish } from "@/api/info";
import InForm from "@/components/InForm";
import { checkPermission, getSessionItem } from "@/utils/permission";
export default {
  components: {
    InForm
  },
  methods: {
    checkPermission,
    toSearch() {
      let that = this;
      that.currentPage = 1;
      that.search = that.carId;
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
      _this.form.carId = temp.carId;
      _this.form.payType = temp.payType;
    },
    submit(row) {
      let that = this;
      finish(row.infoId).then(data => {
        if (data.payType == 1) {
          that.$parent.$alert("支付成功", "提示");
        } else {
          that.$parent.$alert("支付失败", "提示");
        }
        that.getAll();
      });
    },
    remove(row) {
      let that = this;
      this.$confirm("此操作将删除该信息, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        if (row.payStatus == 0) {
          that.$parent.$alert("还未缴费，不能删除", "提示");
        } else {
          remove(row).then(res => {
            that.$parent.$alert("删除成功", "提示");
            that.getAll();
          });
        }
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
      search_phone: null,
      search: "",
      currentPage: 1,
      pageSize: 5,
      totalPages: 0,
      totalElements: 0,
      page_sizes: [5, 10, 15],
      isAdd: true,
      data: [],
      carId: ""
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
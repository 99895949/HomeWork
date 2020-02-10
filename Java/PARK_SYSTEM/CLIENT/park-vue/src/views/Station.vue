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
      <el-table :data="data" border style="width: 100%;">
        <el-table-column fixed prop="cardType" label="车位类型">
          <template slot-scope="scope">
            <span v-if="scope.row.stationType == 0">小型车位</span>
            <span v-else-if="scope.row.stationType == 1">中型车位</span>
            <span v-else>大型车位</span>
          </template>
        </el-table-column>
        <el-table-column prop="stationStatus" label="车位状态">
          <template slot-scope="scope">
            <span v-if="scope.row.stationStatus == 0">空闲</span>
            <span v-else-if="scope.row.stationStatus == 1">已占用</span>
          </template>
        </el-table-column>
        <el-table-column prop="stationLocation" label="车位位置"></el-table-column>
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
    <StationForm ref="form" :is-add="isAdd"></StationForm>
  </div>
</template>

<script>
import { getAll, remove } from "@/api/station";
import StationForm from "@/components/StationForm";
export default {
  components: {
    StationForm
  },
  methods: {
    handleSizeChange(val) {
      let that = this;
      that.pageSize = val;
      that.currentPage = 1;
      getAll(that.currentPage - 1, that.pageSize).then(data => {
        that.data = data.content;
        that.totalPages = data.totalPages;
        that.totalElements = data.totalElements;
      });
    },
    handleCurrentChange(val) {
      let that = this;
      that.currentPage = val;
      getAll(that.currentPage - 1, that.pageSize).then(data => {
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
      _this.form = temp;
    },
    getAll() {
      let that = this;
      getAll(that.currentPage - 1, that.pageSize).then(data => {
        that.data = data.content;
        that.totalPages = data.totalPages;
        that.totalElements = data.totalElements;
        that.totalElements = data.totalElements;
      });
    },
    remove(row) {
      let that = this;
      this.$confirm("此操作将删除该项, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        remove(row.stationId).then(res => {
          that.$parent.$alert("删除成功", "提示");
          that.getAll();
        });
      });
    }
  },

  data() {
    return {
      currentPage: 1,
      pageSize: 5,
      totalPages: 0,
      totalElements: 0,
      page_sizes: [5, 10, 15],
      isAdd: true,
      data: []
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
<template>
  <div>
    <div class="">
      <el-table :data="data" border style="width: 100%;">
        <el-table-column prop="freeLargeCount" label="大型车位"></el-table-column>
        <el-table-column prop="freeMiddleCount" label="中型车位"></el-table-column>
        <el-table-column prop="freeSmallCount" label="小型车位"></el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import { getAllFree } from "@/api/station";
export default {
  methods: {
    getAll() {
      let that = this;
      getAllFree().then(data => {
        let arr = [];
        arr.push(data);
        that.data = arr;
      });
    }
  },

  data() {
    return {
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
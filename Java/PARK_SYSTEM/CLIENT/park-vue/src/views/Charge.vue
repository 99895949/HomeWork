<template>
  <div>
    <!-- <el-row>
      <el-col :span="24">
        <div class="btn-group">
          <el-button type="primary" @click="toAdd()">新增</el-button>
        </div>
      </el-col>
    </el-row>-->
    <div>
      <el-table :data="data" border style="width: 100%;">
        <el-table-column fixed prop="cardType" label="停车卡类型">
          <template slot-scope="scope">
            <span v-if="scope.row.cardType == 0">普通卡</span>
            <span v-else-if="scope.row.cardType == 1">VIP</span>
            <span v-else>散客</span>
          </template>
        </el-table-column>
        <el-table-column prop="stationType" label="停车位类型">
          <template slot-scope="scope">
            <span v-if="scope.row.stationType == 0">小型车位</span>
            <span v-else-if="scope.row.stationType == 1">中型车位</span>
            <span v-else>大型车位</span>
          </template>
        </el-table-column>
        <el-table-column prop="price" label="收费金额(元/小时)"></el-table-column>
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button @click="toEdit(scope.row)" type="primary" size="small">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <ChargeForm ref="form" :is-add="isAdd"></ChargeForm>
  </div>
</template>

<script>
import { getAll, remove } from "@/api/charge";
import ChargeForm from "@/components/ChargeForm";
export default {
  components: {
    ChargeForm
  },
  methods: {
    toEdit(row) {
      this.isAdd = false;
      // 这里获取到了子组件，要传值可以直接通过这个指针
      const _this = this.$refs.form;
      _this.dialog = true;
      let temp = JSON.parse(JSON.stringify(row));
      _this.charge = temp;
    },
    getAll() {
      let that = this;
      getAll().then(data => {
        that.data = data;
      });
    }
  },

  data() {
    return {
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
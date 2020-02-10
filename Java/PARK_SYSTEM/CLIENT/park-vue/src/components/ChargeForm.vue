<template>
  <div>
    <el-dialog :title="isAdd ? '新增收费规则' : '编辑收费规则'" :visible.sync="dialog">
      <el-form ref="form" label-width="100px">
        <el-form-item label="停车卡类型" prop="cardType">
          <el-select disabled v-model="charge.cardType" placeholder="请选择卡片类型" style="width:100%;">
            <el-option
              v-for="item in cardTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="车位类型" prop="stationType">
          <el-select
            disabled
            v-model="charge.stationType"
            placeholder="请选择车位类型"
            style="width:100%;"
          >
            <el-option
              v-for="item in stationTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="费用" prop="price">
          <el-input size="small" v-model="charge.price" placeholder="请输入费用(元/小时)"></el-input>
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
import { update } from "@/api/charge";

export default {
  props: {
    isAdd: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      cardTypes: [
        { label: "VIP", value: 1 },
        { label: "普通卡", value: 0 },
        { label: "散客", value: -1 },
      ],
      stationTypes: [
        { label: "小型车位", value: 0 },
        { label: "中型车位", value: 1 },
        { label: "大型车位", value: 2 }
      ],
      charge: {
        chargeId: 1,
        cardType: 0,
        stationType: 0,
        price: 5.0
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
      this.charge = {
        chargeId: 1,
        cardType: 0,
        stationType: 0,
        price: 5.0
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
      // add(this.charge)
      //   .then(data => {
      //     that.$parent.$alert("添加成功", "提示");
      //     that.reset();
      //     that.$parent.getAll();
      //   })
      //   .catch(function(error) {
      //     console.log(error);
      //   });
    },
    update() {
      let that = this;
      update(this.charge)
        .then(data => {
          that.$parent.$alert("修改成功", "提示");
          that.$parent.getAll();
          that.reset();
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
};
</script>
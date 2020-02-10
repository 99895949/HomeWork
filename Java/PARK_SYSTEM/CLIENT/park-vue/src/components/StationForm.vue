<template>
  <div>
    <el-dialog :title="isAdd ? '新增停车位' : '编辑停车位'" :visible.sync="dialog">
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="车位类型" prop="stationType">
          <el-select v-model="form.stationType" placeholder="请选择车位类型" style="width:100%;">
            <el-option
              v-for="item in stationTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="车位类型" prop="stationType">
          <el-select v-model="form.stationStatus" placeholder="请选择车位状态" style="width:100%;">
            <el-option
              v-for="item in stationStatusArray"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="位置" prop="stationLocation">
          <el-input size="small" v-model="form.stationLocation" placeholder="请输入车位位置"></el-input>
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
import { add, update } from "@/api/station";

export default {
  props: {
    isAdd: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      stationTypes: [
        { label: "小型车", value: 0 },
        { label: "中型车", value: 1 },
        { label: "大型车", value: 2 }
      ],
      stationStatusArray: [
        { label: "空闲", value: 0 },
        { label: "已占用", value: 1 }
      ],
      form: {
        stationId: null,
        stationType: null,
        stationLocation: "",
        stationStatus: null
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
      this.form = {
        stationId: null,
        stationType: null,
        stationLocation: "",
        stationStatus: null
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
      add(this.form)
        .then(data => {
          that.$parent.$alert("添加成功", "提示");
          that.reset();
          that.$parent.getAll();
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    update() {
      let that = this;
      update(this.form)
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
<template>
  <div>
    <el-dialog :title="isAdd ? '新增' : '编辑'" :visible.sync="dialog">
      <el-form ref="form" :model="form"  label-width="100px">
        <el-form-item label="员工编号" prop="empNo">
          <el-input
            size="small"
            v-model="form.empNo"
            placeholder="请输入员工编号"
            :disabled="isAdd == false"
          ></el-input>
        </el-form-item>
        <el-form-item label="员工姓名" prop="empName">
          <el-input size="small" v-model="form.empName" placeholder="请输入员工姓名"></el-input>
        </el-form-item>
        <el-form-item label="员工性别" prop="empGender">
          <el-select v-model="form.empGender" placeholder="请选择性别" style="width:100%;">
            <el-option
              v-for="item in sexTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="员工邮箱" prop="empEmail">
          <el-input size="small" v-model="form.empEmail" placeholder="请输入员工邮箱"></el-input>
        </el-form-item>
        <el-form-item label="所在部门" prop="empGender">
          <el-select v-model="form.deptId" placeholder="请选择所在部门" style="width:100%;">
            <el-option
              v-for="item in deptTypes"
              :key="item.deptId"
              :label="item.deptName"
              :value="item.deptId"
            ></el-option>
          </el-select>
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
import { add, update } from "@/api/employee";
import {getAll} from '@/api/department';
export default {
  props: {
    isAdd: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      form: {
        "empId":"",
        "empName": "",
        "empGender": "",
        "empEmail":"",
        "deptId":"",
        "empNo":""
      },
      dialog: false,
      sexTypes: [
        { label: "男", value: "男" },
        { label: "女", value: "女" }
      ],
      deptTypes:[]
    };
  },
  mounted(){
    let that = this;
    getAll("").then(data=>{
      that.deptTypes = data;
      
    })
  },
  methods: {
    cancel() {
      this.reset();
    },
    reset() {
      this.dialog = false;
      this.form = {
        "empId":"",
        "empName": "",
        "empGender": "",
        "empEmail":"",
        "deptId":"",
        "empNo":""
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
          that.$parent.getData();
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
          that.$parent.getData();
          that.reset();
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
};
</script>
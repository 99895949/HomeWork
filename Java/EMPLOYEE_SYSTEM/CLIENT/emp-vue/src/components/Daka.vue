<template>
    <div class="daka-box">
        <el-form  label-width="80px" style="width:100%;">
            <el-form-item v-if="dialog">
                <el-input v-model="no" placeholder="请输入员工编号"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button style="width:100%;" v-if="dialog" type="primary" @click="submit">登录</el-button>
            </el-form-item>
             <el-form-item>
                <el-button style="width:100%;" v-if="canShangban" type="primary" @click="shangbanClick">上班打卡</el-button>
            </el-form-item>
             <el-form-item>
                <el-button style="width:100%;" v-if="canXiaban" type="primary" @click="xiabanClick">下班打卡</el-button>
            </el-form-item>
             
                
        </el-form>
    </div>
</template>

<script>
import { canshangban,shangban,canxiaban,xiaban } from '@/api/attend';
export default {
    name: 'baseform',
    data() {
        return {
            canShangban:false,
            canXiaban:false,
            no:"",
            dialog:true
           
        };
    },
    methods: {
        shangbanClick() {
            shangban(this.no).then(res =>{
                if(res){
                    this.$alert("上班打卡成功");
                }else{
                    this.$alert("您已打卡，上班打卡失败");
                }
            });
        },
        xiabanClick() {
            xiaban(this.no).then(res =>{
                if(res){
                    this.$alert("下班打卡成功");
                }else{
                    this.$alert("您已打卡，下班打卡失败");
                }
            });
        },
        submit(){
            canshangban(this.no).then(res=>{
                this.canShangban = res;
            });
            canxiaban(this.no).then(res=>{
                this.canXiaban = res;
            });
            this.dialog = false;

        }
        
    }
};
</script>
<style>
.daka-box{
    width:300px;
    margin:0 auto;
    margin-top:200px;
}
</style>
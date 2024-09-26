<template>
  <div style="margin-bottom: 30px; font-size: 20px; font-weight: bold; color: darkgoldenrod">如果你喜欢我就领养我吧
    <div>
      <div style="margin-bottom: 20px">
        <el-input style="width: 240px"placeholder="请输入名称"v-model="params.name"></el-input>
        <el-input style="width: 240px;margin-left: 5px"placeholder="请输入年龄"v-model="params.age"></el-input>
        <el-button style="margin-left: 5px"type="primary"@click="load"><i class=" el-icon-search"></i>搜索</el-button>
        <el-button style="margin-left: 5px"type="primary"@click="reset"><i class=" el-icon-refresh"></i>重置</el-button>
      </div>
      <el-row>
        <el-col :span="5" v-for="pet in tableData">
          <div class="card"style="background-color: cadetblue; text-align: center">
            <img src="@/assets/logo.png" alt="" style="width: 80px; height: 80px; border-radius: 50%">
            <div style="font-weight: bold;color: gold;margin-top: 5px">{{pet.name}}</div>
            <div style="color: darkkhaki;font-size: 13px; margin-top: 5px">性别：{{pet.sex}},年龄{{pet.age}}.<span style="color: deepskyblue"></span>
            </div>
          </div>
        </el-col>
      </el-row>

      <div style="margin-top: 20px">
        <el-pagination
            background
            :current-page="params.pageNum"
            :page-size="params.pageSize"
            layout="prev, pager, next"
            @current-change="handleCurrentChange"
            :total="total">
          </el-pagination>
      </div>
    </div>
  </div>
</template>



<script>
import {Table} from "element-ui";
import request from "@/utils/request";

export default {
  name: 'HomeView',
  data(){
    return{
      tableData:[],
      total:0,
      params:{
        pageNum:1,
        pageSize:12,
        name:'',
        age:''
      }
      }
    },
  created() {
    this.load()
  },
  methods:{
    load(){
      request.get('/user/page',{
        params: this.params
      }).then(res =>{
        if(res.code === '200'){
        this.tableData = res.data.list
        this.total=res.data.total
        }
    })
    },
    reset(){
      this.params = {
        pageNum:1,
        pageSize:12,
        name:'',
        age:''//重置
      }
      this.load()//加载
    },
    handleCurrentChange(pageNum){//分页的实现
       this.params.pageNum=pageNum
       this.load()

    }
  }
}
</script>


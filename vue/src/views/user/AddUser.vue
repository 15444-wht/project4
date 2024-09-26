<template xmlns:el-table="http://www.w3.org/1999/html">
  <div style="padding: 20px">
    <el-form :inline="true" :model="form" >
        <el-upload
            class="avatar-uploader"
            action="https://localhost:9090/user/file/upload"
            :show-file-list="false"
            :on-success="handleCoverSuccess">

          <img v-if="form.cover" :src="form.cover" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      <el-form-item label="姓名">
        <el-input v-model="form.name" placeholder="输入姓名"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.sex" placeholder="输入年龄"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.age" placeholder="输入性别"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.type" placeholder="输入姓名"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.status" placeholder="输入姓名"></el-input>
      </el-form-item>
      <el-form-item label="姓名">
        <el-input v-model="form.jieshao" placeholder="输入姓名"></el-input>
      </el-form-item>
    </el-form>
    <div>
      <el-button @click="save">提交</el-button>
    </div>



  </div>
</template>

<script>
import axios from 'axios';
import request from "@/utils/request";
import user from "@/views/user/User.vue";
export default {
    name: 'AddUser',
    data() {
      return {
        form: {}
      }
    },
    methods: {
      handleCoverSuccess(res){
        if(res.code === '200'){
          this.form.cover=res.data
        }
      },
      save() {
        request.post('/user/save', this.form).then(res => {
          if (res.code === '200') {
            this.$notify.success('cg')
          } else {
            this.$notify.error('sb')

          }
        })

      }

    }

}


</script>
<style>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
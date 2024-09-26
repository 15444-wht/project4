<template>
  <div id="app">
    <!----头--->
    <div style="height: 60px;line-height: 60px;background-color: white;margin-bottom: 2px">
      <img src="@/assets/logo.png"alt=""style="width: 40px;position: relative; top: 10px;left: 20px">
      <span style="margin-left: 25px; font-size: 24px">宠物领养系统</span>
    </div>

    <!----侧---->
    <div style="display: flex">

      <div style="width: 200px; min-height: calc(100vh - 62px); overflow: hidden; margin-right: 2px;background-color: white">
        <el-menu :default-active="$route.path" :default-openeds="['/']" router class="el-menu-demo" >

          <el-menu-item index="/">宠物信息管理</el-menu-item>
          <el-submenu index="/">
            <template slot="title">宠物信息管理</template>
            <el-menu-item index="AddUser">关于详情</el-menu-item>
            <el-menu-item index="User">关于详情</el-menu-item>

          </el-submenu>
        </el-menu>
      </div>


      <!----主--->
      <div style="flex: 1;background-color: white">
        <router-view/>
     </div>
    </div>
  </div>
</template>

<script>
import ImageDownload from './views/user/AddUse.vue';
export default {
  components: {
    ImageDownload,
  },
};
</script>
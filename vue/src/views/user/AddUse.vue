<template>
  <div>
    <h2>Download Image</h2>
    <input v-model="imageName" placeholder="Enter image name" />
    <button @click="downloadImage">Download</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      imageName: '', // 用户输入的图片名称
    };
  },
  methods: {
    async downloadImage() {
      if (!this.imageName) {
        alert('Please enter an image name');
        return;
      }

      try {
        const response = await axios.get(`/download/${this.imageName}`, {
          responseType: 'blob' // 确保获取的是二进制数据
        });

        // 创建一个下载链接
        const url = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', this.imageName); // 设置文件名
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
      } catch (error) {
        alert('Failed to download image: ' + error.message);
      }
    },
  },
};
</script>

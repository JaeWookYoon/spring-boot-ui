<template>
    <div class="coinView">
        <input type="text" id="id" v-model="id"/>
        <input type="password" id="pw" v-model="pw"/>
        <button v-on:click="getToken()">테스트!</button>
        <input type="text" id="token" v-model="token"/>
    </div>
</template>

<script src="./_tokenTest.js" lang="js"></script>
<style src="./_tokenTest.less" lang="less" scoped></style>

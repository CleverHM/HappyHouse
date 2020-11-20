<template>
  <div>
    <div v-if="items.length">
      <table class="table table-bordered table-condensed">
        <colgroup>
          <col :style="{ width: '5%' }" />
          <col :style="{ width: '50%' }" />
          <col :style="{ width: '10%' }" />
          <col :style="{ width: '25%' }" />
        </colgroup>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>날짜</th>
        </tr>
        <tr v-for="(item, index) in items" :key="index + '_items'">
            <td>{{item.qnaNo}}</td>
            <td> <a :href="'#' + item.qnaNo" @click="$router.push({name: 'read', params: {no: item.qnaNo}})">{{item.qnaTitle}}</a> </td>
            <td>{{item.qnaUserid}}</td>
            <td>{{getFormatDate(item.qnaDatetime)}}</td>
          </tr>
      </table>
    </div>
    <div v-else>글이 없습니다.</div>
    <div class="text-right">
      <button class="btn btn-primary" @click="movePage">등록</button>
    </div>
  </div>
</template>

<script>
// import ListRow from '@/components/include/Row.vue';
import axios from 'axios';
import moment from 'moment';
export default {
    name: 'List',
    data: function () {
        return {
            items: [],
        };
    },
    created() {
        axios.get('http://localhost:9999/happyhouse/api/qna').then(({ data }) => {
            this.items = data;
            console.log(this.items);
        });
    },

    methods: {
        getFormatDate(regtime) {
            return moment(new Date(regtime)).format('YYYY.MM.DD');
        },
        movePage() {
            this.$router.push('/create');
        },
    },
}
</script>

<style>

</style>
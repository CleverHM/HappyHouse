<template>
  <div>
      <table class="table table-bordered w-50">
        <tr>
          <th>번호</th>
          <td>{{item.qnaNo}}</td>
        </tr>

        <tr>
          <th>글쓴이</th>
          <td>{{item.qnaUserid}}</td>
        </tr>

        <tr>
          <th>제목</th>
          <td>{{item.qnaTitle}}</td>
        </tr>

        <tr>
          <th>날짜</th>
          <td>{{getFormatDate(item.qnaDatetime)}}</td>
        </tr>

        <tr>
          <th>내용</th>
          <td colspan="2">
            {{item.qnaContent}}
          </td>
        </tr>

        <tr v-if = "item.replyUserid === 'admin'">
          <th>답변</th>
          <td colspan="2">
            {{item.replyContent}}
          </td>
        </tr>

      </table>
      <br/>

      <div class="text-center">
          
          <span v-if= "userid != item.qnaUserid">
            <router-link :to="'/list'"> <button class="btn btn-primary">목록</button></router-link>
            <span v-if= "userid === 'admin'">
              <router-link :to="'/update?no=' + item.qnaNo"><button class="btn btn-primary">수정</button></router-link>
              <router-link :to="'/delete/' + item.qnaNo"><button class="btn btn-primary">삭제</button></router-link>
              <router-link :to="'/reply/' + item.qnaNo"><button class="btn btn-primary">답글</button></router-link>
            </span>
          </span>
        

          <span v-if= "userid === item.qnaUserid">
            <router-link :to="'/list'"> <button class="btn btn-primary">목록</button></router-link>
            <router-link :to="'/update?no=' + item.qnaNo"><button class="btn btn-primary">수정</button></router-link>
            <router-link :to="'/delete/' + item.qnaNo"><button class="btn btn-primary">삭제</button></router-link>
          </span>

      </div>

    </div>
</template>

<script>
import axios from 'axios';
import moment from 'moment';
export default {
    name: 'Read',
    data: function () {
    return {
      item: {},
      userid: '',
    };
  },
  created() {
    // const params = new URL(document.location).searchParams;
    axios.get(`http://localhost:9999/happyhouse/api/qna/${this.$route.params.no}`)
    .then(({ data }) => {
      this.item = data;
      console.log(this.item);
    });

     this.userid = localStorage.getItem('userId');
     console.log(this.userid);
   
  },
  methods: {
    getFormatDate(regtime) {
      return moment(new Date(regtime)).format('YYYY.MM.DD HH:mm:ss');
    },
  },
}
</script>

<style>
</style>
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
      </table>


    <div class="form-group">
      <label for="writer">답변</label>
      <input type="text" class="form-control" id="replycontent" ref="replycontent" placeholder="답변 내용을 입력하세요" v-model="replycontent">
    </div>
   
    <div class="text-right">
      <button class="btn btn-primary" @click="checkHandler">등록</button>
      <button class="btn btn-primary" @click="moveList">목록</button>
    </div>
    
  </div>
</template>

<script>
import axios from 'axios';
import moment from 'moment';

export default {
    name: 'Update',
    data: function () {
    return {
      item: {},
      replycontent: '',
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
    checkHandler() {
      let err = true;
      let msg = '';
      !this.replycontent && ((msg = '작성자를 입력해주세요'), (err = false), this.$refs.replycontent.focus());
      if (!err) alert(msg);
      else this.updateHandler();
    },

    updateHandler() {
      axios
        .put(`http://localhost:9999/happyhouse/api/qna/${this.$route.params.no}`, {
          replyContent: this.replycontent,
          replyUserid: 'admin', 
          qnaNo: this.$route.params.no,
        })
        .then(({ data }) => {
          let msg = '답변 처리시 문제가 발생했습니다.';
          if (data === 'success') {
            msg = '답변이 완료되었습니다.';
          }
          alert(msg);
          this.$router.push('/');
        });
    },

    getFormatDate(regtime) {
      return moment(new Date(regtime)).format('YYYY.MM.DD HH:mm:ss');
    },

    moveList() {
      this.$router.push('/');
    },

  },
}
</script>

<style>

</style>
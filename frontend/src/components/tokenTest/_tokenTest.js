// @vue/component
import axios from 'axios';
export default {
    name: 'TokenTest',

    components: {       
    },

    mixins: [],

    props: {},

    data () {
        return {
            tokenInfo:null,
            id:null,
            pw:null,
            token:"TOKEN",
            user:{
                id:null,
                pw:null
            }
        }
    },

    computed: {},

    watch: {
        id:function(){
            this.user.id = this.id;
        },
        pw:function(){
            this.user.pw = this.pw;
        }
    },

    created () {
    },

    methods: {
        
        getToken:function() {
            axios.post('/call/token',{
                    data:{
                        id:this.user.id,
                        pw: this.user.pw
                    },
                    headers: { "content-Type": `application/json`}
                })
            .then(res => {
                //console.log(res);
                this.token = JSON.stringify(res.data);                
            });
        },
        publicTest:function() {
            axios.post('/call/token')
            .then(res => {
                console.log(res);
                                
            });
        },
        privateTest:function() {
            axios.post('/call/token',{
                headers: { 
                    "content-Type": `application/json`,
                    "bearer": this.token.access_token
                }
            })
            .then(res => {
                console.log(res);
                                
            });
        }
    }
}

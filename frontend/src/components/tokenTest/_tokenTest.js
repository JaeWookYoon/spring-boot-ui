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
            token:null
        }
    },

    computed: {},

    watch: {},

    created () {
    },

    methods: {
        
        getToken:function(){
            var param = {
                "id":this.id,
                "pw":this.pw
            };
            axios.post('/api/token',param)
            .then(res => {
                console.log(res);
            });
        }
    }
}

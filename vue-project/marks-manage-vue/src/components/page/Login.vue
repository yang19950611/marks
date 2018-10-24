<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">后台管理系统</div>
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="0px" class="ms-content">
                <el-form-item prop="username">
                    <el-input v-model="ruleForm.username" placeholder="username">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input type="password" placeholder="password" v-model="ruleForm.password"
                              @keyup.enter.native="submitForm('ruleForm')">
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>
                </el-form-item>
                <div v-show="data.isErr" class="login-err">
                    <span>{{data.msg}}</span>
                </div>
                <div class="login-btn">
                    <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                </div>
            </el-form>
        </div>
    </div>
</template>

<script>
    export default {
        data: function () {
            return {
                data:{
                    msg:'',
                    isErr:false
                },
                ruleForm: {
                    username: '',
                    password: ''

                },
                rules: {
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'}
                    ]
                }
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    const self = this;
                    if (valid) {
                        this.$http.post('/api/login', {
                            user_name: self.ruleForm.username,
                            pass_word: self.ruleForm.password
                        }, {emulateJSON: true}).then((response) => {
                            // success callback
                            if(response.data.code == 0){
                                let username = sessionStorage.setItem('ms_username',self.ruleForm.username);
                                sessionStorage.setItem('token',response.data.data.token);
                                console.log(self.$route.query);
                                if(self.$route.query.redirect != null){
                                    self.$router.push({path:decodeURIComponent(self.$route.query.redirect)});
                                }else{
                                    self.$router.push('/');
                                }
                            }else{
                                self.data.isErr = true;
                                self.data.msg =response.data.msg;
                            }
                        }, (response) => {
                            // error callback
                        });

                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            }
        }
    }
</script>

<style scoped>
    .login-wrap {
        position: relative;
        width: 100%;
        height: 100%;
        background-image: url(../../assets/login-bg.jpg);
        background-size: 100%;
    }

    .ms-title {
        width: 100%;
        line-height: 50px;
        text-align: center;
        font-size: 20px;
        color: #fff;
        border-bottom: 1px solid #ddd;
    }

    .ms-login {
        position: absolute;
        left: 50%;
        top: 50%;
        width: 350px;
        margin: -190px 0 0 -175px;
        border-radius: 5px;
        background: rgba(255, 255, 255, 0.3);
        overflow: hidden;
    }

    .ms-content {
        padding: 30px 30px;
    }

    .login-btn {
        text-align: center;
    }

    .login-btn button {
        width: 100%;
        height: 36px;
        margin-bottom: 10px;
    }

    .login-tips {
        font-size: 12px;
        line-height: 30px;
        color: #fff;
    }

    .login-err{
        float: right;
        font-size: 15px;
        color: red;
        padding-bottom: 15px
    }
</style>

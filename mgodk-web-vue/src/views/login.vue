<template>
    <div class="login_container">
        <div class="login_box">
            <div class="avatar_box">
                <img alt="Vue logo" src="../assets/logo.png">
            </div>
            <el-form class="login_form" ref="loginFormRef" :model="loginForm" :rules="loginFormRules"
                     lable-width="100px">
                <el-form-item prop="username"><!--label="用户名" -->
                    <el-input type="text" prefix-icon="iconfont icon-user"
                              v-model="loginForm.username" placeholder="请输入账户"></el-input>
                </el-form-item>
                <el-form-item prop="password"><!--label="密  码" -->
                    <el-input type="password" prefix-icon="iconfont icon-lock"
                              v-model="loginForm.password" placeholder="请输入密码"></el-input>
                </el-form-item>
                <!--<el-form-item prop="btn">-->
                    <!--<el-button type="primary" @click="login" :loading="btLogin.loadingFlag">{{btLogin.loginMsg}}</el-button>-->
                    <!--<el-button type="primary" @click="reset">重置</el-button>-->
                <!--</el-form-item>-->
            </el-form>
            <span class="btn_box">
                <el-button type="primary" @click="login" :loading="btLogin.loadingFlag">{{btLogin.loginMsg}}</el-button>
                <el-button type="primary" @click="reset">重置</el-button>
            </span>
        </div>
        <!--<div class="foot_box">@私人杂货铺</div>-->
    </div>
</template>

<script>
    export default {
        name: "login",
        props: {},
        watch: {},
        component: {},
        computed: {},
        created: function () {
            const vue = this;
            //电脑按键输入触发事件
            document.onkeydown = function (e) {
                let key = window.event.keyCode;
                if (key === 13) {
                    vue.login();
                }
            };
        },
        data: function () {
            return {
                btLogin: {
                    loginMsg: '登录',//登录按钮显示
                    loadingFlag: false,//登录按钮状态
                },
                //表单相关属性
                loginForm: {
                    username: 'admin',
                    password: '123456',
                },
                loginFormRules: {
                    username: [
                        {required: true, message: '必填,请输入登录账户', trigger: 'blur'},
                        {min: 3, max: 10, message: '账户名称长度在3~10个字符之间', trigger: 'blur'},
                    ],
                    password: [
                        {required: true, message: '必填,请输入登录密码', trigger: 'blur'},
                        {min: 3, message: '登录密码长度不得少于3', trigger: 'blur'},
                    ],
                },
            };
        },
        methods: {
            reset: function () {
                this.$refs.loginFormRef.resetFields();
            },
            login: function () {
                this.btLogin.loadingFlag = true;
                this.btLogin.loginMsg = '登录中';
                console.log('登录==================');/////////////////////////////////////////////
                this.$refs.loginFormRef.validate(async valid => {
                    if (!valid) {
                        return;
                    }
                    /*let params = this.$qs.stringify(this.loginForm);
                    const {data: res} = this.$http.post('/',params).then(function (res) {
                        if (res.data.code == 200) {}
                        this.$message.success('登录成功！');
                    }).catch(function (e) {
                        this.$message.error('登录失败！');
                    }).finally(() => {
                        this.$message.info('登录请求执行结束');
                    });*/
                    //console.log(res);////////// ////////// ////////// ////////// ////////// /////
                    this.btLogin.loginMsg = '登录';
                    this.btLogin.loadingFlag = false;
                    //跳转页面
                    // let path = this.$route.query.redirect;
                    // if (!path) {
                    //     path = "/home";
                    // }
                    // this.$router.push(path);
                });
            },
        },
    }
</script>

<style lang="less" scoped>
    .login_container {
        background: #0099FF;
        height: 100%;
        background-size: cover;
    }
    .login_box {
        width: 400px;
        height: 300px;
        margin-top: 4%;
        background-color: antiquewhite;
        border-radius: 20px;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        .avatar_box {
            width: 130px;
            height: 130px;
            border: 1px solid #eee;
            border-radius: 50%;
            padding: 10px;
            box-shadow: 0 0 10px #ddd;
            position: absolute;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #0099FF;
            img {
                width: 100%;
                height: 100%;
                border-radius: 50%;
                background-color: white;
            }
        }
        .login_form {
            position: absolute;
            top: 35%;
            width: 100%;
            padding: 0 30px;
            box-sizing: border-box;
        }
        .btn_box {
            position: absolute;
            left: 0;
            top: 80%;
            width: 100%;
            padding: 0 30px;
            box-sizing: border-box;
        }
    }
    /*.foot_box {
        width: 100%;
        color: #fff;
        font-size: 26px;
        font-weight: bolder;
        text-align: center;
        position: absolute;transform: translate(-50%, -50%);
        bottom: 20px;
        display: flex;
        justify-content: center;
    }*/
</style>

document.write('<title>杂货铺后台管理系统-V1.0</title>');
document.write('<meta charset="utf-8">');
document.write('<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />');
document.write('<meta name="renderer" content="webkit|ie-comp|ie-stand">');
document.write('<meta name="viewport" content="width=device-width,user-scalable=no" />');
document.write('');
document.write('<link rel="stylesheet" type="text/css" href="/static/css/common.css">');
document.write('<script type="text/javascript" th:src="@{/static/js/jquery-1.12.4.min.js}" src="/static/js/jquery-1.12.4.min.js"></script>');
/** 字体图标插件 */
document.write('<link rel="stylesheet" type="text/css" href="/static/font/iconfont.css">');
/** BootStrap 相关插件 */
document.write('<link rel="stylesheet" type="text/css" href="/static/js/plugins/bootstrap/css/bootstrap.css">');
document.write('<script type="text/javascript" src="/static/js/plugins/bootstrap/js/bootstrap.js"></script>');
document.write('<link rel="stylesheet" type="text/css" href="/static/js/plugins/bootstrap-daterangepicker/css/daterangepicker.css">');
document.write('<script type="text/javascript" src="/static/js/plugins/bootstrap-daterangepicker/js/daterangepicker.js"></script>');
document.write('<link rel="stylesheet" type="text/css" href="/static/js/plugins/bootstrap-fileinput/css/fileinput.css">');
document.write('<script type="text/javascript" src="/static/js/plugins/bootstrap-fileinput/js/fileinput.js"></script>');
document.write('<link rel="stylesheet" type="text/css" href="/static/js/plugins/bootstrap-iconpicker/css/bootstrap-iconpicker.css">');
document.write('<script type="text/javascript" src="/static/js/plugins/bootstrap-iconpicker/js/bootstrap-iconpicker.js"></script>');
document.write('<link rel="stylesheet" type="text/css" href="/static/js/plugins/bootstrap-select/css/bootstrap-select.css">');
document.write('<script type="text/javascript" src="/static/js/plugins/bootstrap-select/js/bootstrap-select.js"></script>');
document.write('<link rel="stylesheet" type="text/css" href="/static/js/plugins/bootstrap-table/css/bootstrap-table.css">');
document.write('<script type="text/javascript" src="/static/js/plugins/bootstrap-table/js/bootstrap-table.js"></script>');
document.write('<link rel="stylesheet" type="text/css" href="/static/js/plugins/bootstrap-treeview/css/bootstrap-treeview.css">');
document.write('<script type="text/javascript" src="/static/js/plugins/bootstrap-treeview/js/bootstrap-treeview.js"></script>');
document.write('<link rel="stylesheet" type="text/css" href="/static/js/plugins/bootstrap-validator/css/bootstrapValidator.css">');
document.write('<script type="text/javascript" src="/static/js/plugins/bootstrap-validator/js/bootstrapValidator.js"></script>');
/** Toastr 消息框插件 */
document.write('<link rel="stylesheet" type="text/css" href="/static/js/plugins/toastr/toastr.css">');
document.write('<script type="text/javascript" src="/static/js/plugins/toastr/toastr.min.js"></script>');

/**  */
window.onload = function () {
    $("#head").load("/templates/common/head.html");
};

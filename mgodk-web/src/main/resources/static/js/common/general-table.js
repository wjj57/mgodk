$(function () {});

/*
  #####
  jQuery.fn = jQuery.prototype = {} --添加类
  jQuery.extend({}) --添加类方法
  jQuery.extend(target, object1);   --扩展对象
  jQuery.fn.extend(object) =  jQuery.prototype.extend  --添加成员函数
  //
  $.fn.tooltip = function(options){}; =等价于= var tooltip = { function(options){} };


  ##### Bootstrap Table
  ---------- ---------- ---------- -columns 列参数：
    field   -该列映射的data的参数名，默认 undefined;
    title   -该列的表头名，默认 undefined;
    formatter   -格式化单元格内容，function(value, row, index), value：该cell本来的值，row：该行数据，index：该行序号（从0开始）;
    events  -The cell 的事件监听;
    radio   -是否显示单选，默认 false;
    checkbox    -是否显示多选，默认 false;
    titleTooltip/class/align/halign/falign/valign/width/visible/sortable/......
  ---------- ---------- --------- -事件
  onAll、onClickRow、onDblClickRow、onClickCell、onDblClickCell、onSort、onCheck、onUncheck、onCheckAll、
  onUncheckAll、onCheckSome、onUncheckSome、onLoadSuccess、onLoadError、onColumnSwitch、onColumnSearch、
  onPageChange、onSearch、onToggle、onPreBody、onPostBody、onPostHeader、onExpandRow、onCollapseRow、
  onRefreshOptions、onRefresh、
  ---------- ---------- --------- -方法
  getOptions、load、refresh、refreshOptions、getSelections、
  getAllSelections、getData、getRowByUniqueId、showAllColumns、hideAllColumns、refreshOptions、resetSearch、
  append、prepend、remove、removeAll、removeByUniqueId、insertRow、updateRow、showRow、hideRow、getRowsHidden、
  mergeCells、showLoading、prevPage、nextPage、selectPage、toggleView、......
*/

$.fn.extend({
    createTable:function (options) {
        this.bootstrapTable({
            //
            treeId: options.treeId,
            treeView: options.treeView,
            parentIdField: options.parentIdField,
            treeField: options.treeField,
            treeRootLevel: options.treeRootLevel,
            treeCollapseAll: options.treeCollapseAll,
            rowStyle: options.rowStyle,

            ////////// ////////// ////////// ////////// //基本参数 属性
            url: options.url, //请求后台的URL（*）
            method: options.type, //请求方式（*）
            contentType: 'application/json;charset=utf-8', //发送到服务器的数据编码类型，默认 application/json
            dataType: 'json', //服务器返回的数据类型，默认 json
            ////////// ////////// ////////// ////////// //查询参数 属性
            queryParams: options.queryParams, //传递参数（*）
            queryParamsType: '', //默认为‘limit’则，发送符合 RESTFul 格式的参数
            //idField: 'undefined', //指定主键列，默认 undefined
            uniqueId: options.uniqueId, //每一行的唯一标识，一般为主键列，默认 undefined
            ////////// ////////// ////////// ////////// //分页参数 属性
            columns: options.tableColumn, //表头数据
            toolbar: options.toolbar, //工具按钮用哪个容器
            pagination: options.pagination, //是否 显示分页（*）
            singleSelect: options.singleSelect,
            pageList: [5,10,15,20,25], //可供选择的每页的行数（*）
            pageNumber: 1,//初始化加载 页数
            pageSize: options.pageSize === undefined ? 10 : options.pageSize,//初始化 单页记录行数
            //height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
            minimumCountColumns: 2, //最少允许的列数
            sortOrder: "asc", //排序方式(desc、asc)
            sortable: true, //是否 启用排序
            striped: true, //是否 显示行间隔色
            cache: false, //是否 使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            showPaginationSwitch: options.showPaginationSwitch, //是否 显示分页开关
            clickToSelect: true, //是否 启用点击选中行
            search: false, //是否 显示表格搜索，默认 false，此搜索是客户端搜索，不会进服务端
            strictSearch: true, //是否 全匹配搜索，否则为模糊搜索，默认 false
            showToggle: false, //是否 显示详细视图和列表视图的切换按钮，默认 false
            cardView: false, //是否 显示详细视图，默认 false
            detailView: false, //是否 显示父子表、详细页面模式，默认 false
            showColumns: options.showColumns, //是否 显示所有列（内容列下拉框），默认 false
            showRefresh: options.showRefresh, //是否 刷新按钮，默认 false
            ////////// ////////// ////////// ////////// //扩展属性
            paginationLoop: true, //默认为 true，启用分页条无限循环的功能
            onlyInfoPagination: false, //默认为 false，为 true 只显示总数据数，而不显示分页按钮。需要 pagination=’True’
            showHeader: true, //是否 显示列头，默认 true
            showFooter: false, //是否 显示列脚，默认 false

            //加载服务器数据之前的处理程序，可以用来格式化数据
            responseHandler: function (res) {
                if(options.pagination){
                    return {
                        "total": res.total,
                        "rows": res.rows,
                    };
                }
                return {
                    "rows": res.data,
                };
            },

            ////////// ////////// ////////// ////////// //Option 事件
            onAll:options.onAll, //所有的事件都会触发该事件，参数包括：name：事件名，args：事件的参数。
            onClickRow:options.onClickRow, //点击某一行的时候触发，参数包括：row：点击行的数据，$element：tr 元素，field：点击列的 field 名称。
            onDblClickRow:options.onDblClickRow, //双击某一行的时候触发，参数包括：row：点击行的数据，$element：tr 元素，field：点击列的 field 名称。
            onClickCell: options.onClickCell, //点击某一列的时候触发，参数包括：field：点击列的 field 名称，value：点击列的 value 值，row：点击列的整行数据，$element：td 元素。
            onDblClickCell: options.onDblClickCell, //双击某一列的时候触发，参数包括：field：点击列的 field 名称，value：点击列的 value 值，row：点击列的整行数据，$element：td 元素。
            onSort: options.onSort, //对列进行排序时触发，参数包含：name: 排序列字段名，order: 排序列的顺序
            onCheck: options.onCheck, //检查行时触发，参数包含：row: 与单击的行对应的记录. $element: 选中DOM元素.
            onUncheck: options.onUncheck, //取消选中行时触发，参数包含：row: 与单击的行对应的记录. $element: 选中DOM元素.
            onCheckAll: options.onCheckAll, //检查所有行时触发，参数包含：rows: 与新检查的行对应的记录数组
            onUncheckAll: options.onUncheckAll, //取消选中所有行时触发，参数包含：rows: 与新检查的行对应的记录数组
            onCheckSome: options.onCheckSome, //检查某些行时触发，参数包含：rows: 与新检查的行对应的记录数组
            onUncheckSome: options.onUncheckSome, //取消选中某些行时触发，参数包含：rows: 与新检查的行对应的记录数组
            onLoadSuccess:options.onLoadSuccess, //在成功加载远程数据时触发，参数包含：data
            //在加载远程数据时发生某些错误时触发，参数包含：status
            onLoadError : function(status,data){
                if(status==403){
                    var $errorMsg = $('<td colspan="12"><div class="m-error"><b class="error-icon">&nbsp;</b> <span class="error-text"><b class="text1">没有权限,请联系系统管理员!</b><b class="text2"></b></span> </div></td>');
                    $(".no-records-found").empty().append($errorMsg);
                }else{
                    var $errorMsg = $('<td colspan="12"><div class="m-error"><b class="error-icon">&nbsp;</b> <span class="error-text"><b class="text1">很抱歉，系统加载异常......</b><b class="text2"></b></span> </div></td>');
                    $(".no-records-found").empty().append($errorMsg);
                }
            },
            onColumnSwitch: options.onColumnSwitch, //切换列可见时触发，参数包含：field, checked
            onColumnSearch: options.onColumnSearch, //在按列搜索时触发，参数包含：field, text
            onPageChange: options.onPageChange, //更改页码或页面大小时触发，参数包含：number, size
            onSearch: options.onSearch, //在搜索表时触发，参数包含：text
            onToggle: options.onToggle, //切换表视图时触发，参数包含：cardView
            onPreBody: options.onPreBody, //在呈现表体之前触发，参数包含：data
            onPostBody: options.onPostBody, //在表体表示并在DOM中可用之后触发，参数包含：none
            onPostHeader: options.onPostHeader, //在表头之后触发，并在DOM中可用，参数包含：none
            onExpandRow: options.onExpandRow, //当点击详细图标展开详细页面的时候触发，参数包含：index, row, $detail
            onCollapseRow: options.onCollapseRow, //当点击详细图片收起详细页面的时候触发，参数包含：index, row
            onRefreshOptions: options.onRefreshOptions,//在刷新选项之后和在销毁和初始化表之前触发，参数包含：options
            onRefresh: options.onRefresh, //单击刷新按钮后触发，参数包含：params
        });
    },

    refreshTable:function(){
        this.bootstrapTable("refreshOptions",{pageNumber:1});
    },
});
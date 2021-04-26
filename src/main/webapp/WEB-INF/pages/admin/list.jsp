<%--
  Created by IntelliJ IDEA.
  User: Little_Crab
  Date: 2021/4/12
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>人员管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../static/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../static/css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="name" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">学号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="id" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">年级</label>
                            <div class="layui-input-inline">
                                <input type="text" name="grade" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">身份</label>
                            <div class="layui-input-inline">
                                <select name="identitytype">
                                    <option value="">请选择你的身份</option>
                                    <option value="2">学生</option>
                                    <option value="1">教师</option>
                                    <option value="0">管理员</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">学院</label>
                            <div class="layui-input-inline">
                                <input type="hidden" name="deptId" autocomplete="off" class="layui-input" id="deptId">
                                <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input"
                                       id="deptRadio">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">专业</label>
                            <div class="layui-input-inline">
                                <input type="hidden" name="majorId" autocomplete="off" class="layui-input" id="majorId">
                                <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input"
                                       id="majorRadio">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">班级</label>
                            <div class="layui-input-inline">
                                <input type="hidden" name="classId" autocomplete="off" class="layui-input" id="classId">
                                <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input"
                                       id="classRadio">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary" lay-submit
                                    lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索
                            </button>
                        </div>

                    </div>
                </form>
            </div>
        </fieldset>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加</button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 删除</button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>

    </div>
</div>
<script src="../static/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="../static/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['form', 'table', 'tableSelect'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table, tableSelect = layui.tableSelect;

        table.render({
            elem: '#currentTableId',
            url: 'query',
            method: "POST",
            contentType: 'application/json',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print'],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'id', width: 100, title: 'ID', sort: true},
                {field: 'name', width: 80, title: '姓名'},
                {field: 'sex', width: 80, title: '性别', templet: "<div>{{d.sex==0?'女':'男'}}</div>", sort: true},
                {field: 'age', width: 80, title: '年龄'},
                {field: 'grade', width: 80, title: '年级'},
                {field: 'majorName', width: 180, title: '专业', templet: "<div>{{d.major.majorName}}</div>"},
                {field: 'idcard', width: 200, title: '身份证号'},
                {field: 'phone', width: 150, title: '手机号', sort: true},
                {field: 'email', width: 200, title: '邮箱'},
                {field: 'className', width: 150, title: '班级', templet: "<div>{{d.class_exam.className}}</div>"},
                {field: 'deptName', width: 180, title: '学院', templet: "<div>{{d.department.deptName}}</div>"},
                // {field: 'identitytype', width: 120, title: '职业', templet: "<div>{{d.identitytype==2?'学生':'教师'}}</div>"}
                {
                    field: 'identitytype', width: 120, title: '职业', templet: function (d) {
                        if (d.identitytype === 0) {
                            return "管理员";
                        } else if (d.identitytype === 1) {
                            return "教师";
                        } else if (d.identitytype === 2) {
                            return "学生";
                        }
                    }
                }
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 15,
            page: true,
            skin: 'line'
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            if ($("#deptRadio").val() === "") {
                data.field.deptId = "";
            }
            if ($("#majorRadio").val() === "") {
                data.field.majorId = "";
            }
            if ($("#classRadio").val() === "") {
                data.field.classId = "";
            }
            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                },
                contentType: 'application/json'
                , where: data.field
            }, 'data');
            return false;
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '添加用户',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'create',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                var arr = [];
                for (index in data) {
                    arr.push(data[index].id);
                }
                $.ajax({
                    url: 'delete',
                    method: 'POST',
                    dataType: 'json',
                    data: 'ids=' + arr.join(','),
                    success: function (data) {
                        layer.msg(data.msg, {time: 500}, function () {
                            table.reload('currentTableId');
                        })
                    }
                });
            }
        });
        //专业选择
        tableSelect.render({
            elem: '#majorRadio',
            checkedKey: 'majorId',
            table: {
                method: 'POST',
                contentType: 'application/json',
                url: '../major/query',
                cols: [[
                    {type: 'radio'},
                    {field: 'majorId', title: '专业号'},
                    {field: 'majorName', title: '专业名称'}
                ]]
            },
            done: function (elem, data) {
                var NEWJSON = []
                layui.each(data.data, function (index, item) {
                    document.getElementById('majorId').value = item.majorId;
                    NEWJSON.push(item.majorName)
                })
                elem.val(NEWJSON.join(","))
            }
        });
        tableSelect.render({
            elem: '#deptRadio',
            checkedKey: 'deptId',
            table: {
                method: 'POST',
                contentType: 'application/json',
                url: '../dept/query',
                cols: [[
                    {type: 'radio'},
                    {field: 'deptId', title: '学院号'},
                    {field: 'deptName', title: '学院名称'}
                ]]
            },
            done: function (elem, data) {
                var NEWJSON = []
                layui.each(data.data, function (index, item) {
                    document.getElementById('deptId').value = item.deptId;
                    NEWJSON.push(item.deptName)
                })
                elem.val(NEWJSON.join(","))
            }
        });
        tableSelect.render({
            elem: '#classRadio',
            checkedKey: 'classId',
            table: {
                method: 'POST',
                contentType: 'application/json',
                url: '../class/query',
                cols: [[
                    {type: 'radio'},
                    {field: 'classId', title: '班级号'},
                    {field: 'className', title: '班级名称'}
                ]]
            },
            done: function (elem, data) {
                var NEWJSON = []
                layui.each(data.data, function (index, item) {
                    document.getElementById('classId').value = item.classId;
                    NEWJSON.push(item.className)
                })
                elem.val(NEWJSON.join(","))
            }
        });
        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {

                var index = layer.open({
                    title: '编辑用户',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '../page/table/edit.html',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'delete') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });

    });

</script>

</body>
</html>


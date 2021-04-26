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
    <title>试卷管理</title>
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
                            <label class="layui-form-label">考试名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="id" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">状态</label>
                            <div class="layui-input-inline">
                                <select name="state">
                                    <option value="">请选择你的身份</option>
                                    <option value="考试中">考试中</option>
                                    <option value="未开始">未开始</option>
                                    <option value="已结束">已结束</option>
                                </select>
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
                <button class="layui-btn  layui-btn-sm data-add-btn" lay-event="add"> 添加</button>
                <button class="layui-btn layui-btn-sm  data-delete-btn" lay-event="delete"> 删除</button>
                <button class="layui-btn layui-btn-sm data-add-btn" lay-event="editQuestion"><i
                        class="fa fa-pencil"></i>
                    试卷设计
                </button>
                <button class="layui-btn layui-btn-sm data-add-btn" lay-event="preview"><i class="fa fa-search"></i>
                    试卷预览
                </button>
                <button class="layui-btn layui-btn-sm data-add-btn" lay-event="publish"><i class="fa fa-search"></i>
                    问卷发布
                </button>
                <button class="layui-btn layui-btn-sm data-add-btn" lay-event="query_detail"><i
                        class="fa fa-search"></i>
                    问卷详情
                </button>
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
                {field: 'title', width: 200, title: '试卷名称'},
                {field: 'remark', width: 200, title: '备注'},
                {field: 'state', width: 150, title: '状态'},
                {field: 'startTime', width: 150, title: '考试时间'},
                {field: 'endTime', width: 150, title: '结束时间',},
                {field: 'examLength', width: 90, title: '考试时长', templet: "<div>{{d.examLength+'小时'}}</div>"},
                {field: 'url', width: 550, title: '考试地址'}
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
            } else if (obj.event === 'editQuestion') {  // 监听添加操作

                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                var arr = [];
                for (index in data) {
                    arr.push(data[index].id);
                }
                if (arr.length !== 1) {
                    layer.msg("请选择一行数据进行修改", {time: 100});
                    return;
                }

                var index = layer.open({
                    title: '编辑问题',
                    type: 2,
                    shade: 0.2,
                    maxmin: false,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'question?id=' + arr[0],
                    end: function () {
                        table.reload('currentTableId');
                    }
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'publish') {  // 监听添加操作

                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                var arr = [];
                for (index in data) {
                    arr.push(data[index].id);
                }
                if (arr.length !== 1) {
                    layer.msg("请选择一行数据进行修改", {time: 1000});
                    return;
                }

                $.ajax({
                    url: 'publish',
                    type: 'POST',
                    dataType: 'json',
                    data: 'id=' + arr[0],
                    success: function (data) {
                        layer.msg(data.msg, {
                            time: 2000
                        }, function () {
                            table.reload('currentTableId');
                        });
                    }
                });
            } else if (obj.event === 'preview') {  // 监听添加操作

                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                var arr = [];
                for (index in data) {
                    arr.push(data[index].id);
                }
                if (arr.length !== 1) {
                    layer.msg("请选择一行数据进行修改", {time: 100});
                    return;
                }
                window.open("preview/" + arr[0]);
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


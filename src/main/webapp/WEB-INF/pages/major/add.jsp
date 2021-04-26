<%--
  Created by IntelliJ IDEA.
  User: Little_Crab
  Date: 2021/4/13
  Time: 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../static/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="../static/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label required">专业号</label>
        <div class="layui-input-block">
            <input type="text" name="majorId" lay-verify="required" lay-reqtext="专业号不能为空" placeholder="请输入专业号" value=""
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">专业名称</label>
        <div class="layui-input-block">
            <input type="text" name="majorName" lay-verify="required" lay-reqtext="专业名称不能为空" placeholder="请输入专业名称"
                   value=""
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学院</label>
        <div class="layui-input-inline">
            <input type="hidden" name="deptId" autocomplete="off" class="layui-input" id="deptId">
            <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input" id="deptRadio">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="../static/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="../static/js/lay-config.js?v=1.0.4" charset="utf-8"></script>
<script>
    layui.use(['form', 'tableSelect', 'table', 'laydate'], function () {
        var form = layui.form, layer = layui.layer, $ = layui.$,
            table = layui.table, tableSelect = layui.tableSelect, laydate = layui.laydate;
        laydate.render({
            elem: '#birthday',
            type: 'date'
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
        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var index = parent.layer.getFrameIndex(window.name);
            $.ajax({
                url: "create",
                type: "Post",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(data.field),
                success: function (data) {
                    layer.msg(data.msg, {
                        time: 500
                    }, function () {
                        parent.layer.close(index);
                    });
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
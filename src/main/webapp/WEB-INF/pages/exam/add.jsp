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
        <label class="layui-form-label required">试卷名称</label>
        <div class="layui-input-block">
            <input type="text" name="title" lay-verify="required" lay-reqtext="课程号不能为空" placeholder="请输入课程号" value=""
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">备注</label>
        <div class="layui-input-block">
            <input type="text" name="remark" lay-verify="required" lay-reqtext="课程名称不能为空" placeholder="请输入课程名称"
                   value=""
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-inline">
        <label class="layui-form-label">考试时间</label>
        <div class="layui-input-inline">
            <input type="text" name="startTime" id="startTime" lay-verify="datetime"
                   placeholder="yyyy-MM-dd HH:mm:ss" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-inline">
        <label class="layui-form-label">结束时间</label>
        <div class="layui-input-inline">
            <input type="text" name="endTime" id="endTime" lay-verify="datetime"
                   placeholder="yyyy-MM-dd HH:mm:ss" class="layui-input">
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
            elem: '#startTime',
            type: 'datetime'
        });
        laydate.render({
            elem: '#endTime',
            type: 'datetime'
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
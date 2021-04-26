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
        <label class="layui-form-label required">账户</label>
        <div class="layui-input-block">
            <input type="text" name="id" lay-verify="required" lay-reqtext="账户不能为空" placeholder="请输入账户" value=""
                   class="layui-input">
            <tip>填写自己管理账号的账户。</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="required" lay-reqtext="姓名不能为空" placeholder="请输入姓名" value=""
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">年级</label>
        <div class="layui-input-block">
            <input type="text" name="grade" lay-verify="required" lay-reqtext="年级不能为空" placeholder="请输入年级" value=""
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">密码</label>
        <div class="layui-input-block">
            <input type="text" name="password" lay-verify="required" lay-reqtext="姓名不能为空" placeholder="请输入姓名"
                   value="123456"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="1" title="男" checked="">
            <input type="radio" name="sex" value="0" title="女">
        </div>
    </div>
    <div class="layui-form-item layui-inline">
        <label class="layui-form-label">出生日期</label>
        <div class="layui-input-inline">
            <input type="text" name="birthday" id="birthday" lay-verify="date"
                   placeholder="yyyy-MM-dd" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-inline">
        <label class="layui-form-label required">年龄</label>
        <div class="layui-input-block">
            <input type="text" name="age" lay-reqtext="年龄" placeholder="请输入年龄"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">身份证号</label>
        <div class="layui-input-block">
            <input type="number" name="idcard" lay-verify="required" lay-reqtext="身份证号不能为空" placeholder="请输入身份证号"
                   value="" class="layui-input">
            <tip>填写合法的第二代身份证号。</tip>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">手机</label>
        <div class="layui-input-block">
            <input type="number" name="phone" lay-verify="required" lay-reqtext="手机不能为空" placeholder="请输入手机" value=""
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="email" name="email" placeholder="请输入邮箱" value="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学院</label>
        <div class="layui-input-inline">
            <input type="hidden" name="deptId" autocomplete="off" class="layui-input" id="deptId">
            <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input" id="deptRadio">
        </div>
        <label class="layui-form-label">专业</label>
        <div class="layui-input-inline">
            <input type="hidden" name="majorId" autocomplete="off" class="layui-input" id="majorId">
            <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input" id="majorRadio">
        </div>
        <label class="layui-form-label">班级</label>
        <div class="layui-input-inline">
            <input type="hidden" name="classId" autocomplete="off" class="layui-input" id="classId">
            <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input" id="classRadio">
        </div>
    </div>
    <div class="layui-form-item layui-inline">
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
        })
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
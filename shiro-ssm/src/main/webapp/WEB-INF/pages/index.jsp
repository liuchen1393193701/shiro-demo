
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台系统</title>
    <link rel="stylesheet" href="statics/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    <script src="statics/zTree_v3/js/jquery-1.4.4.min.js"></script>
    <script src="statics/zTree_v3/js/jquery.ztree.all.min.js"></script>
    <style type="text/css" >
        .container{
            width: 1200px;
        }
        #leftsdd{
            width: 200px;
            height: 500px;
            float: left;
            border: 1px solid #ccc;
        }
        #right{
            width: 950px;
            height: 500px;
            float: left;
            border: 1px solid #ccc;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            var setting={
                view:{
                    showLine:true
                },
                data:{
                    simpleData:{//简单数据模式
                        enable:true,
                        idKey:"id",
                        pIdKey:"pId",
                        rootPId:null
                    }
                },
                callback:{
                    onClick:openNew
                }
            };
            $.ajax({
                url:'leftMenu.html',
                type:"GET",
                dataType:"json",
                success:function (data) {
                    console.log(data);
                   ztreeObj= $.fn.zTree.init($("#treeDemo"),setting,data);
                    ztreeObj.expandAll(true);
                }
            });
        });
        function openNew(p1,p2,p3) {
            console.log(p3);
            $("#title").html(p3.name);
            $("#content").attr("src",p3.url);
            event.preventDefault();
        }
    </script>
</head>
<body>
    <div id="leftsdd">
        <ul id="treeDemo" class="ztree"></ul>
    </div>
    <div id="right">
        <div id="title"></div>
        <div>
            <iframe id="content" width="100%" height="450px" style="border: none"></iframe>
        </div>
    </div>
</body>
</html>

<%-- 
    Document   : sidebar
    Created on : Mar 15, 2018, 4:14:02 PM
    Author     : thuanenvity
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Elearning-Admin</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                    <button type="submit" name="search" id="search-btn" class="btn btn-flat">
                        <i class="fa fa-search"></i>
                    </button>
                </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MAIN NAVIGATION</li>
            </li>
            <li class="treeview">
                <a href="http://localhost:8084/ElearningAdmin/course/courses">
                    <i class="fa fa-fw fa-bars"></i>
                    <span>Khóa học</span>
                    <span class="pull-right-container">
                    </span>
                </a>
            </li>
            <li class="treeview">
                <a href="http://localhost:8084/ElearningAdmin/user/allusers">
                    <i class="ion ion-ios-gear-outline"></i>
                    <span>Người dùng</span>
                    <span class="pull-right-container">
                    </span>
                </a>
            </li>





        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'gateway/list',
        datatype: "json",
        colModel: [			
			{ label: 'gwId', name: 'gwId', index: 'gw_id', width: 50, key: true,hidden:true },
			{ label: '网关序列号', name: 'gwSn', index: 'gw_sn', width: 80 }, 					
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 },	
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 }	
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		gateway: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.gateway = {};
		},
		update: function (event) {
			var gwId = getSelectedRow();
			if(gwId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(gwId)
		},
		saveOrUpdate: function (event) {
			var url = vm.gateway.gwId == null ? "gateway/save" : "gateway/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.gateway),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var gwIds = getSelectedRows();
			if(gwIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "gateway/delete",
                    contentType: "application/json",
				    data: JSON.stringify(gwIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(gwId){
			$.get(baseURL + "gateway/info/"+gwId, function(r){
                vm.gateway = r.gateway;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});
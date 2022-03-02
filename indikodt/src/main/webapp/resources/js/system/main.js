var main = new function() {

	var that = this;

	/**=====================================================
	| 최초 실행 이벤트
	*=====================================================*/
	that.init = function() {
		/*-------------
		 | 이벤트 선언.
		 ------------*/
		/*-------------
		 | 초기값 설정.
		 ------------*/
		$("#tabpageHeader1").addClass('active');
		$("#tabpageBody1").addClass('active');


	},
	/**=====================================================
	| 탭페이지 이동
	*=====================================================*/
	that.fn_pageMove = function(obj){

		let appendStr = "";
		//menuId = 1100001;
		//menuUrl = /views/system/main_back.do?tabpageNo=1
		const tabpage = $("#tabpages").children('li');

		//tabpageHeader 셋팅
		appendStr = '<li class="nav-item tab-header">' + "\n" +
			'<a id="tabPageHeader'+(tabpage.length+1)+'" href="#tabpageBody'+(tabpage.length+1)+'" data-toggle="tab" class="nav-link rounded-0 pt-2 pb-2 tab-pageHeader-a">' + "\n" +
			'<span class="d-none d-sm-inline tab-pageHeader-span">'+"Profile" + "\n" +
			'<i id="closeTabpage'+(tabpage.length+1)+'" class="fe-x tap-icon02" onclick="main.fn_closeTabpasge(this);"></i></span>' + "\n" +
			'</a> </li>';
		$("#tabpages").append(appendStr);

		//tabpageBody 셋팅
		appendStr = '<div class="tab-pane" id="tabpageBody'+(tabpage.length+1)+'">' +
			'<tiles:insertAttribute name="content'+(tabpage.length+1)+'" />' +
			'</div>';

		$("#tabContent").append(appendStr);

        $.ajax({
		 	url: '/system/main_back.do',
		 	async:false,
		    data: {"tabpageNo":(tabpage.length+1)},
		    type: 'POST',
		    success:function(data){

		    	$("#tabpages").find(".active").removeClass('active');
		    	$("#tabContent").find(".active").removeClass('active');
				$("#tabPageHeader"+(tabpage.length+1)).addClass('active');
				$("#tabpageBody"+(tabpage.length+1)).addClass('active');
		    },
		    error:function(request,status,error){
		        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
		    }
         });

	},
	/**=====================================================
	| 탭페이지 닫기
	*=====================================================*/
	that.fn_closeTabpasge = function(obj){
		$("#"+obj.id).parents("li").remove()
	}


};

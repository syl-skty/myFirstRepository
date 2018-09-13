/**
 * 
 * 通过此方法可以实现异步地向服务器上传文件，并显示进度，
 * 但经测试，当文件大小在1.5G左右时会出现服务器由于连接时间过长而导致的无法接收文件
 * 
 * @param {Object} fileInput 要上传文件对应的<input>输入框对象
 * @param {Object} cacelButton	取消上传的按钮对应的对象
 * @param {Object} show 要显示进度的对象，这里显示进度时，会将其html内容改为当前的进度百分比
 * @param {String} url 服务器url地址
 * @param {String} fileName 文件名字，相当于<input>标签的name属性，不重要
 */
function uploadFile(formdata, cacelButton, show, url, fileName) {

	//创建一个FormData对象，这个对象能够将一个<input type="file">的文件内容封装成一个form表单提交给服务器
	//var data = new FormData();

	//在前面创建的FormData对象的内容中添加我们<input type="file">的文件内容,files[0]表示input标签中添加的第一个文件
	//前面的FormData对象就相当于是一个form表单，现在我们往表单里添加我们需要的input标签对应的文件
	//使用键值对的方式添加，前面就是指定的名字（相当于<input>标签的name）,不重要
	//data.append(fileName, $(fileInput)[0].files[0]);

	var cacel = false; //创建一个标识用于表示我们是否取消发送

	//为取消当前上传事件的按钮添加一个click事件，当点击此按钮时，就会将标识cacel的值改为true
	if (cacelButton != undefined || cacelButton != null) {
		$(cacelButton).click(function() {
			cacel = true;
		});
	}
	//使用ajax发送文件
	$.ajax({
		url: url, //服务器地址
		type: 'POST', //使用post方式发送
		cache: false, //不使用缓存
		data: formdata, //我们要发送的FormData数据对象
		async: true, //使用异步方式提交，这里必须使用异步，不然后面我们使用XHR对象来监听上传的进度将无法实现监听
		processData: false, //关闭jquery的数据处理，让其自动处理我们的文件
		contentType: false, //让jquery不自动配置我们的文件类型

		//注册事件来监听我们xmlHttpReuest对象的变化，在发送文件的过程中的变化
		//用于上传进度监听
		xhr: function() {
			var myXhr = $.ajaxSettings.xhr(); //获取当前上传文件使用的xmlHttpRequest对象，用于监听进度

			if (myXhr.upload) //判断当前的xmlHttpRequest对象是否存在upload对象，也就是判断上传事件存不存在
			{
				//为当前的XHR对象的上传进度progress事件添加监听器
				//每次上传进度progress属性的值改变都会触发一次此事件
				myXhr.upload.addEventListener("progress", function(e) {

					//每次触发显示进度的函数前先判断是否点击了取消按钮
					if (cacel) {
						//如果点击了，就调用当前XHR对象的abort()方法，取消当前XHR的请求，取消与服务器的交互
						myXhr.abort();
					}

					//获取文件按已经上传完的字节总数，使用事件的属性loaded
					var loaded = e.loaded;
					//获取文件的总字节数，使用事件e的total属性
					var total = e.total;

					//计算当前上传完成的进度
					var percent = Math.floor((loaded * 100 / total)) + "%";

					//由于实际上传完成的字节与计算出来的百分比又一定的差距，当显示为完成100%时，让其显示为99%,等待上传成功的回调函数再将其改为100%
					if (percent == "100%") {
						percent = "99%";
					}

					//显示当前上传进度
					$(show).html(percent).css("width", percent);

				}, false); //将是否使用事件冒泡设置为false，即先捕获子事件
			}

			return myXhr; //将XHR对象返回
		},

		//注册上传成功的回调函数
		success: function(da) {

			//上传成功后则将进度改为100%
			$("#percent").html("100%").css("width", "100%");
		},
	});

}
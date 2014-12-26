<nav id="menu-wrap">
<input type="hidden" id="contextPath" value="${pageContext.request.contextPath }">    
	<ul id="menu">
		<li><a href="/">Home</a></li>

		<li>
			<a href="">manage</a>
			<ul>
				<li>
					<a href="">menu</a>
					<ul>
						<li><a href="">Item 11</a></li>

						<li><a href="">Item 12</a></li>
						<li><a href="">Item 13</a></li>
						<li><a href="">Item 14</a></li>
					</ul>				
				</li>
				<li>
					<a href="">athority</a>

					<ul>
						<li><a href="">Item 21</a></li>
						<li><a href="">Item 22</a></li>
						<li><a href="">Item 23</a></li>
						<li><a href="">Item 24</a></li>
					</ul>				
				</li>

				<li>
					<a href="${pageContext.request.contextPath }/usermng/userMng.do">employee</a>
					<ul>
						<li><a href="">Item 31</a></li>
						<li><a href="">Item 32</a></li>
						<li><a href="">Item 33</a></li>
						<li><a href="">Item 34</a></li>

					</ul>				
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/department/departList.do">department</a>				
					<ul>
						<li><a href="">Item 41</a></li>
						<li><a href="">Item 42</a></li>
						<li><a href="">Item 43</a></li>

						<li><a href="">Item 44</a></li>
					</ul>	
				</li>
				<li>
					<a href="">anniversary</a>				
					<ul>
						<li><a href="">Item 41</a></li>
						<li><a href="">Item 42</a></li>
						<li><a href="">Item 43</a></li>

						<li><a href="">Item 44</a></li>
					</ul>	
				</li>
				<li>
					<a href="">lunchMenu</a>				
					<ul>
						<li><a href="">Item 41</a></li>
						<li><a href="">Item 42</a></li>
						<li><a href="">Item 43</a></li>

						<li><a href="">Item 44</a></li>
					</ul>	
				</li>
			</ul>
		</li>
		<li>
			<a href="">Work</a>
			<ul>

				<li>
					<a href="">Work 1</a>
					<ul>
						<li>
							<a href="">Work 11</a>		
							<ul>
								<li><a href="">Work 111</a></li>
								<li><a href="">Work 112</a></li>

								<li><a href="">Work 113</a></li>
							</ul>							
						</li>
						<li>
							<a href="">Work 12</a>
							<ul>
								<li><a href="">Work 121</a></li>
								<li><a href="">Work 122</a></li>

								<li><a href="">Work 123</a></li>
							</ul>							
						</li>
						<li>
							<a href="">Work 13</a>
							<ul>
								<li><a href="">Work 131</a></li>
								<li><a href="">Work 132</a></li>

								<li><a href="">Work 133</a></li>
							</ul>							
						</li>
					</ul>					
				</li>
				<li>
					<a href="">Work 2</a>
					<ul>
						<li>

							<a href="">Work 21</a>
							<ul>
								<li><a href="">Work 211</a></li>
								<li><a href="">Work 212</a></li>
								<li><a href="">Work 213</a></li>
							</ul>							
						</li>

						<li>
							<a href="">Work 22</a>
							<ul>
								<li><a href="">Work 221</a></li>
								<li><a href="">Work 222</a></li>
								<li><a href="">Work 223</a></li>
							</ul>							
						</li>

						<li>
							<a href="">Work 23</a>
							<ul>
								<li><a href="">Work 231</a></li>
								<li><a href="">Work 232</a></li>
								<li><a href="">Work 233</a></li>
							</ul>							
						</li>

					</ul>					
				</li>
				<li>
					<a href="">Work 3</a>
					<ul>
						<li>
							<a href="">Work 31</a>
							<ul>

								<li><a href="">Work 311</a></li>
								<li><a href="">Work 312</a></li>
								<li><a href="">Work 313</a></li>
							</ul>							
						</li>
						<li>
							<a href="">Work 32</a>

							<ul>
								<li><a href="">Work 321</a></li>
								<li><a href="">Work 322</a></li>
								<li><a href="">Work 323</a></li>
							</ul>							
						</li>
						<li>
							<a href="">Work 33</a>

							<ul>
								<li><a href="">Work 331</a></li>
								<li><a href="">Work 332</a></li>
								<li><a href="">Work 333</a></li>
							</ul>							
						</li>
					</ul>					
				</li>

			</ul>		
		</li>
		<li><a href="">About</a></li>
		<li><a href="">Contact</a></li>
	</ul>
</nav>
<script type="text/javascript">
    $(function() {
		if ($.browser.msie && $.browser.version.substr(0,1)<7)
		{
		$('li').has('ul').mouseover(function(){
			$(this).children('ul').css('visibility','visible');
			}).mouseout(function(){
			$(this).children('ul').css('visibility','hidden');
			})
		}

		/* Mobile */
		$('#menu-wrap').prepend('<div id="menu-trigger">Menu</div>');		
		$("#menu-trigger").on("click", function(){
			$("#menu").slideToggle();
		});

		// iPad
		var isiPad = navigator.userAgent.match(/iPad/i) != null;
		if (isiPad) $('#menu ul').addClass('no-transition');      
    });          
</script>


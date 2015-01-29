<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/app/rank_mng.js"></script>

<div ng-app="rankApp">
	<div ng-controller="rankController">
		<h3>{{title}}</h3>
<!-- 
		<table>
			<tr ng-repeat="x in names">
				<td>{{ x.rankName }}</td>
				<td>{{ x.rankCode }}</td>
			</tr>
		</table>
 -->
  <p><strong>Page:</strong> {{tableParams.page()}}
    <p><strong>Count per page:</strong> {{tableParams.count()}}
 
 <table ng-table="tableParams" class="table ng-table-responsive">
            <tr ng-repeat="rank in $data">
                <td data-title="'Name'">
                    {{rank.rankName}}
                </td>
                <td data-title="'Age'">
                    {{rank.rankCode}}
                </td>
            </tr>
        </table>

	</div>
</div>
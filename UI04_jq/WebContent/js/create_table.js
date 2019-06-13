function makeTable(ele) {
	$table = $("<table border=1>");
	// $변수 --> jquery변수(jquery 메서드 사용 가능)
	for(var i=0;i<1;i++) {
		$tr = $("<tr>");
		for(var j=0;j<ele.eq(0).children().length;j++) {
			$td = $("<th>").append(ele.eq(0).children().eq(j).prop("tagName"));
			// console.log(ele.eq(0).children().eq(j).prop("tagName"));
			// console.log(ele.eq(0).children().eq(j).attr("tagName"));
			$tr.append($td);
		}
		$table.append($tr);
	}
	for(var i=0;i<ele.length;i++) {
		$tr = $("<tr>");
		for(var j=0;j<ele.eq(i).children().length;j++) {
			$td = $("<td>").append(ele.eq(i).children().eq(j).text());
			$tr.append($td);
		}
		$table.append($tr);
	}
	
	return $table;
}
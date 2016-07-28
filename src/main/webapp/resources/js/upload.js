function checkImageType(fileName){
	
	var pattern = /jpg|gif|png|jpeg/i;
	
	return fileName.match(pattern);
	
}

function getFileInfo(img_src){
	
	var fileName, imgsrc, getLink;
	
	var fileLink;
	
	if(checkImageType(img_src)){
		imgsrc = "/displayFile?fileName=" + img_src;
		fileLink = img_src.substr(14);
		
		var front = img_src.substr(0, 12);
		var end = img_src.substr(14);
		
		getLink = "/displayFile?fileName=" + front + end;
	} else {
		imgsrc = "/resources/dist/img/file.png";
		fileLink = img_src.substr(12);
		getLink = "/displayFile?fileName=" + img_src;
	}
	
	fileName = fileLink.substr(fileLink.indexOf("_") + 1);
	
	return {fileName:fileName, imgsrc:imgsrc, getLink:getLink, img_src:img_src};
	
}
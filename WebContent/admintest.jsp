<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
</head>
<body>
<script type='text/javascript'>
            function handleDownload() {
            	var moji='あいうえお,かきくけこ,さしすせそ';
                var bom = new Uint8Array([0xEF, 0xBB, 0xBF]);
                var content = moji;
                var blob = new Blob([ bom, content ], { "type" : "text/csv" });

                if (window.navigator.msSaveBlob) {
                    window.navigator.msSaveBlob(blob, "java.csv");

                    // msSaveOrOpenBlobの場合はファイルを保存せずに開ける
                    window.navigator.msSaveOrOpenBlob(blob, "java.csv");
                } else {
                    document.getElementById("download").href = window.URL.createObjectURL(blob);
                }
            }
        </script>
        <a id="download" href="#" download="java.csv" onclick="handleDownload()">ダウンロード</a>

</body>
</html>
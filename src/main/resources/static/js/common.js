var main = {
    init : function() {
        console.log('common.js init 로드');
        var _this = this;

        $('button').on('click', function () {
            console.log('test 호출');
            _this.test();
        });


        console.log('common.js 초기화 완료');
    },

    test : function (url) {
        console.log('test 호출');
        $.ajax({
            type: 'POST',
            url: 'api/admin/test',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify({})
        }).done(function (data) {
            console.log('호출');
            console.log(data);
            alert('성공' + data);
        }).fail(function (error) {
            console.log('실패');
            console.log(error)
            alert('실패');
            history.back();
        })
    }
};

// main.init();
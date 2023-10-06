var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            wind: $('#wind').val()
        };

        axios.post('/save', data, {
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
            }
        })
            .then(function (response) {
                var successMessage = response.data.message;
                alert(successMessage);
                $('#wind').val('');
            })
            .catch(function (error) {
                if (error.response && error.response.status === 400) {
                    if (error.response.data) {
                        var errorMessage = error.response.data.message;
                        alert(errorMessage);
                    } else {
                        alert('서버에서 오류 메세지가 전송되지 않았습니다.');
                    }
                } else {
                    alert('Server error: ' + error.message);
                }
            });
    }
}

main.init();

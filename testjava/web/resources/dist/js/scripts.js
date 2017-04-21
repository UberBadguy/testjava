/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * Método que devuelve la posición de un elemento en un string.
 *
 * @param  string   f_haystack  Texto a origen.
 * @param  string   f_needle    Texto a buscar.
 * @param  int      f_offset    Segunda Posición.
 * @return mixed                Posición encontrada | false.
 *
 */

function stripos( f_haystack, f_needle, f_offset ) {

    var haystack = ( f_haystack + '' ).toLowerCase();
    var needle = ( f_needle + '' ).toLowerCase();
    var index = 0;

    if ( ( index = haystack.indexOf( needle, f_offset ) ) !== -1)
        return index;

    return false;

}

/*
 *
 * Fn
 * -----------------------------
 *
 * Objeto que contiene las validaciones para aplicar sobre un rut en particular.
 * La forma de utilizar es Fn.validaRut( rut ).
 *
 * @param  string   rutCompleto     Rut a revisar (debe contender dígito verificador).
 * @return boolean                  Es un Rut válido.
 *
 */

var Fn = {

    validaRut: function( rutCompleto ) {
        rutCompleto = rutCompleto.replace( /\./g, '' );
        var $length = rutCompleto.length;
        var $pos = stripos( rutCompleto, '-' );

        if ( $pos == '0' )
            rutCompleto = rutCompleto.substring( 0, $length - 1 ) + '-' + rutCompleto.substring( $length - 1, $length );

        if ( !/^[0-9]+-[0-9kK]{1}$/.test( rutCompleto ) )
            return false;

        var tmp = rutCompleto.split( '-' );
        var digv = tmp[1];
        var rut = tmp[0];

        if ( digv == 'K' )
            digv = 'k';

        var digesto = Fn.dv( rut );

        if ( digesto == digv )
            return true;
        else
            return false;
    },
    dv: function( t ) {
        var m = 0, s = 1;

        for ( ; t; t = Math.floor( t / 10 ) )
            s = ( s + t % 10 * ( 9 - m++ % 6 ) ) % 11;

        return s ? s - 1 : 'k';
    }

};

(function ($) {
    
    $(document).ajaxStart(function() { Pace.restart(); });
    $(document).ajaxComplete(function(){ $('table-ajax').dataTable(); });
    if ($('.checkbox').length) {
        $('.checkbox').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%'
        });
    }
    
    if ($('.datepicker').length) {
        $('.datepicker').datepicker({
          autoclose: true,
          format: 'dd-mm-yyyy'
        });
    }
    $('#login').on('click', function (e) {
        if (!MiConstructora.validForm())
            return;
        else {
            var data = MiConstructora.dataFormMantenedor();
            $.ajax({
                url: 'valida.htm',
                data: 'action=login' + data,
                type: 'POST',
                success: function (data) {
                    if (data.response === 1) {
                        swal({
                            title: "Logeado!",
                            text: "",
                            type: "success"
                        },
                                function () {
                                    window.location.replace('index.htm');
                                });
                    } else {
                        swal({
                            title: "Error al intentar logear!",
                            text: "Intente nuevamente.",
                            type: "error"
                        });
                    }
                },
                error: function () {
                    swal({
                        title: "Error al intentar logear!",
                        text: "Intente nuevamente.",
                        type: "error"
                    });
                }
            });
        }
        e.preventDefault();
    });

    $('#registra').on('click', function (e) {
        if (!MiConstructora.validForm())
            return;
        else {
            var data = MiConstructora.dataFormMantenedor();
            $.ajax({
                url: 'registrarse.htm',
                data: 'action=register' + data,
                type: 'POST',
                success: function (data) {
                    if (data.response === 1) {
                        swal({
                            title: "Usuario registrado!",
                            text: "",
                            type: "success"
                        },
                                function () {
                                    location.reload();
                                });
                    } else {
                        swal({
                            title: "Error al registrar el usuario!",
                            text: "Intente nuevamente.",
                            type: "error"
                        });
                    }
                },
                error: function () {
                    swal({
                        title: "Error al registrar el usuario!",
                        text: "Intente nuevamente.",
                        type: "error"
                    });
                }
            });
        }
        e.preventDefault();
    });

    if ($('#mantenedor').length) {
        $('#mantenedor').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
    }

    if ($('#asistencia').length) {
        $('#asistencia').DataTable({
            "autoWidth": false
        });
    }

    if ($('select').length) {
        $('select').select2({
            placeholder: "Seleccione...",
            allowClear: true
        });
    }
    
    $('#region_id').select2().on('change', function() {
        if (this.value > 0) {
            $.ajax({
                url: './provincias',
                data: {region_id: this.value},
                type: 'POST',
                success: function (data) {
                    if (typeof(data.provinces) !== undefined) {
                        $('#province_id').html('').select2({
                            data: data.provinces
                        });
                    } else {
                        swal({
                            title: "Error al buscar provincias!",
                            text: "Intente nuevamente.",
                            type: "error"
                        });
                    }
                },
                error: function () {
                    swal({
                        title: "Error al buscar provincias!",
                        text: "Intente nuevamente.",
                        type: "error"
                    });
                }
            });
        }
    });
    
    $('#province_id').select2().on('change', function() {
        if (this.value > 0) {
            $.ajax({
                url: './comunas',
                data: {province_id: this.value},
                type: 'POST',
                success: function (data) {
                    if (typeof(data.districts) !== undefined) {
                        $('#district_id').html('').select2({
                            data: data.districts
                        });
                    } else {
                        swal({
                            title: "Error al buscar comunas!",
                            text: "Intente nuevamente.",
                            type: "error"
                        });
                    }
                },
                error: function () {
                    swal({
                        title: "Error al buscar comunas!",
                        text: "Intente nuevamente.",
                        type: "error"
                    });
                }
            });
        }
    });
    
    $('#newItem').on('click', function () {
        MiConstructora.clearFormMantanedor();
        $('#new').modal('show');
    });

    $('#addNew').on('click', function () {
        var data = MiConstructora.dataFormMantenedor();
        if (!MiConstructora.validForm())
            return;
        $('#new').modal('hide');
        var controller = $(this).attr('data-controller');
        var url = $(this).attr('data-url');
        swal({
            title: 'Envío de datos',
            text: 'Está seguro de la información ingresada?',
            type: "warning",
            showCancelButton: true,
            closeOnConfirm: false,
            animation: 'slide-from-top',
            showLoaderOnConfirm: true
        },
        function () {
            $.ajax({
                url: url,
                data: 'controller=' + controller + data,
                type: "POST",
                success: function (data) {
                    if (data.response === 1) {
                        swal({
                            title: "Datos guardados!",
                            text: "",
                            type: "success"
                        },
                        function () {
                            location.reload();
                        });
                    } else {
                        swal({
                            title: "Error al guardar los datos!",
                            text: "Intente nuevamente.",
                            type: "error"
                        });
                    }
                },
                error: function () {
                    swal({
                        title: "Error al guardar los datos!",
                        text: "Intente nuevamente.",
                        type: "error"
                    });
                }
            });
        });
    });

    $('#new').on('hidden.bs.modal', function () {
        MiConstructora.clearFormMantanedor();
    });
    
    $('body').on('click', '.btnDetalles', function () {
        MiConstructora.fillDetails($(this).attr('data-rut'), $(this).attr('data-url'));
        $('#new').modal('show');
    });

    $('body').on('click', '.btnEditar', function () {
        MiConstructora.fillInputMantenedor($(this).attr('data-id'), $(this).attr('data-url'));
        $('#new').modal('show');
    });

    $('body').on('click', '.btnEliminar', function () {
        var id = $(this).attr('data-id');
        var url = $(this).attr('data-url');
        swal({
            title: 'Eliminar Registro',
            text: 'Está seguro que desea eliminar este registro?',
            type: "warning",
            showCancelButton: true,
            closeOnConfirm: false,
            animation: 'slide-from-top',
            showLoaderOnConfirm: true
        },
        function () {
            $.ajax({
                url: url,
                data: 'id=' + id,
                type: "POST",
                success: function (data) {
                    if (data.response === 1) {
                        swal({
                            title: "Registro eliminado!",
                            text: "",
                            type: "success"
                        },
                                function () {
                                    location.reload();
                                });
                    } else {
                        swal({
                            title: "Error al eliminar el registro!",
                            text: "Intente nuevamente.",
                            type: "error"
                        });
                    }
                },
                error: function () {
                    swal({
                        title: "Error al eliminar el registro!",
                        text: "Intente nuevamente.",
                        type: "error"
                    });
                }
            });
        });
    });
    
    $('body').on('click', '.btnMarcaje', function () {
        var rut = $(this).attr('data-id');
        var url = $(this).attr('data-url');
        var type = $(this).attr('data-original-title');
        swal({
            title: 'Marcar Asistencia',
            text: 'Está seguro que desea registrar asistencia?',
            type: "warning",
            showCancelButton: true,
            closeOnConfirm: false,
            animation: 'slide-from-top',
            showLoaderOnConfirm: true
        },
        function () {
            $.ajax({
                url: url,
                data: 'rut=' + rut + '&type=' + type,
                type: "POST",
                success: function (data) {
                    if (data.response === 1) {
                        swal({
                            title: "Marcaje registrado!",
                            text: "",
                            type: "success"
                        },
                                function () {
                                    location.reload();
                                });
                    } else {
                        swal({
                            title: "Error al registrar marcaje!",
                            text: "Intente nuevamente.",
                            type: "error"
                        });
                    }
                },
                error: function () {
                    swal({
                        title: "Error al registrar marcaje!",
                        text: "Intente nuevamente.",
                        type: "error"
                    });
                }
            });
        });
    });
    
    $('#report-selector').select2().on('change', function() {
        if (this.value > 0) {
            $.ajax({
                url: $(this).data('url'),
                data: {id: this.value},
                type: 'POST',
                success: function (data) {
                    if(data!=null){
                        $('#report-table').html(data);
                    } else {
                        swal({
                            title: "Error al obtener datos!",
                            text: "Intente nuevamente.",
                            type: "error"
                        });
                    }
                },
                error: function () {
                    swal({
                        title: "Error al obtener datos!",
                        text: "Intente nuevamente.",
                        type: "error"
                    });
                }
            });
        }
    });

    var MiConstructora = {
        dataFormMantenedor: function () {
            var data = '';
            $('.form').find('.form-control').each(function () {
                if ($(this).parent('[class*="icheckbox"]').length>0)
                    data += '&' + $(this).attr('name') + '=' + ($(this).parent('[class*="icheckbox"]').hasClass("checked")?1:0);
                else
                    data += '&' + $(this).attr('name') + '=' + $(this).val();
            });
            return data;
        },
        clearFormMantanedor: function () {
            $('#addForm').find('.form-control').each(function () {
                if ($(this).is('select'))
                    $(this).val(null).trigger('change');
                else if ($(this).attr('type') === 'hidden')
                    $(this).val('0');
                else
                    $(this).val('');
            });
        },
        fillInputMantenedor: function (id, url) {
            $.ajax({
                url: url,
                data: 'id=' + id,
                type: "GET",
                success: function (data) {
                    $('#addForm').find('.form-control').each(function () {
                        if ($(this).is('select'))
                            $(this).select2('val', data.data[$(this).attr('name')]);
                        else
                            $(this).val(data.data[$(this).attr('name')]);
                    });
                }
            });
        },
        fillDetails: function (rut, url) {
            
            $.ajax({
                url: url,
                data: 'rut=' + rut,
                type: "GET",
                success: function (data) {
                    $('#details').find('.data').each(function () {
                        console.log($(this).attr('id'));
                        $(this).text(data.data[$(this).attr('id')]);
                    });
                }
            });
        },
        validForm: function () {
            var valid = true;
            $('.form').find('.form-control').each(function () {
                if ($(this).attr('required') === 'required' || $(this).attr('required') === 'true') {
                    if ($(this).hasClass('rut')) {
                        if (!Fn.validaRut($(this).val())) {
                            $(this).parents('.form-group').addClass('has-error');
                            valid = false;
                        } else
                            $(this).parents('.form-group').removeClass('has-error');
                    } else if ($(this).val() === '' || $(this).val() === null) {
                        $(this).parents('.form-group').addClass('has-error');
                        valid = false;
                    } else
                        $(this).parents('.form-group').removeClass('has-error');
                }
            });
            return valid;
        }
    };
    
    function formatMoney ( number, places, symbol, thousand, decimal ) {
        places = !isNaN(places = Math.abs(places)) ? places : 0;
        symbol = symbol !== undefined ? symbol : '$';
        thousand = thousand || '.';
        decimal = decimal || ',';
        var number = number,
                negative = number < 0 ? '-' : '',
                i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + '',
                j = (j = i.length) > 3 ? j % 3 : 0;
        return symbol + ' ' + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, '$1' + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : '');
    };
    
}(jQuery));

var originalPrimeFacesCw = PrimeFaces.cw;
PrimeFaces.cw = function (name, id, options, resource) {
    resource = resource || name.toLowerCase();
    originalPrimeFacesCw.apply(this, [name, id, options, resource]);
};

$(document).ready(function () {
    $('input[id*="cuil_input"').mask('99-99999999-9');
});

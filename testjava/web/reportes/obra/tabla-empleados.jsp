<table id="mantenedor" class="table table-bordered table-hover">
    <thead>
        <tr>
            <th>Rut</th>
            <th>Nombre</th>
            <th>Perfil</th>
            <th>Dias Trabajados</th>
            <th>Horas Trabajadas</th>
            <th>Atrasos</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listado}" var="employeeDTO">
            <tr>
                <td>${employeeDTO.rut}</td>
                <td>${employeeDTO.full_name}</td>
                <td>${employeeDTO.role}</td>
                <td>${employeeDTO.worked_days}</td>
                <td>${employeeDTO.worked_hours}</td>
                <td>${employeeDTO.delayed_entry}</td>
            </tr>
        </c:forEach>
    </tbody>
    <tfoot></tfoot>
</table>
import { useEffect } from "react"
import moment from 'moment';

const ListarTareas = ({tarea,setTareas,tareas,setTareasActualizada}) => {

    const handleDelete = (id)=>{
        const request = {
            method: 'DELETE'
        }

        fetch("http://localhost:8088/tareas/" + id, request)
        .then(res => res.text())
        .then(res=> console.log(res))

        setTareasActualizada(true)
    }

    const handleUpdate = (id)=> {
        tarea.id = id;
        console.log(tarea);
        const request = {
            method: 'PUT',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(tarea)
        }

        fetch("http://localhost:8088/tareas", request)
        .then(res => res.text())
        .then(res=> console.log(res))

        setTareasActualizada(true)
    }

    let{descripcion, fechaCreacion, vigente} = tarea

    useEffect(() => {
        fetch("http://localhost:8088/tareas")
        .then(rs => rs.json())
        .then(data => setTareas(data))
        setTareasActualizada(false)
    }, [])
    return(
        <div>
            <table className="table">
                <thead className="thead-dark">
                    <tr>
                        <th>#</th>
                        <th>Descripcion</th>
                        <th>Fecha</th>
                        <th>Vigente</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        tareas ? (
                        tareas.map((item)=>(
                            <tr key={item.id}>
                                <td>{item.id}</td>
                                <td>{item.descripcion}</td>
                                <td>{moment(item.fechaCreacion).format('DD-MM-YYYY')}</td>
                                <td>{
                                    (item.vigente)? "SI": "NO"
                                    }</td>
                                <td>
                                    <button onClick={()=>handleDelete(item.id)} className="btn btn-danger">Eliminar</button>&nbsp;&nbsp;
                                    <button onClick={() => handleUpdate(item.id)} className="btn btn-dark">Editar</button>
                                </td>
                            </tr>
                        ))
                    ): (<span>Cargando...</span>)
                    }
                </tbody>
            </table>
        </div>
    )
}

export default ListarTareas
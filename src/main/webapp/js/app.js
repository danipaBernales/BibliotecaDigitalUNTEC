// CONFIRMAR ELIMINACIÓN

function confirmarEliminacion() {

    return confirm(
        "¿Desea eliminar este préstamo?"
    );
}

// VALIDAR LOGIN

function validarLogin() {

    const correo =
        document.querySelector(
            'input[name="correo"]'
        ).value;

    const password =
        document.querySelector(
            'input[name="password"]'
        ).value;

    if (
        correo.trim() === "" ||
        password.trim() === ""
    ) {

        alert(
            "Complete todos los campos"
        );

        return false;
    }

    return true;
}

// VALIDAR FORMULARIO PRÉSTAMO

function validarPrestamo() {

    const usuarioId =
        document.querySelector(
            'input[name="usuarioId"]'
        ).value;

    const libroId =
        document.querySelector(
            'input[name="libroId"]'
        ).value;

    if (
        usuarioId <= 0 ||
        libroId <= 0
    ) {

        alert(
            "IDs inválidos"
        );

        return false;
    }

    return true;
}

// EFECTO SIMPLE

document.addEventListener(
    "DOMContentLoaded",
    () => {

        const container =
            document.querySelector(
                ".container"
            );

        if (container) {

            container.style.opacity = 0;

            setTimeout(() => {

                container.style.transition =
                    "opacity 1s";

                container.style.opacity = 1;

            }, 100);
        }
    }
);

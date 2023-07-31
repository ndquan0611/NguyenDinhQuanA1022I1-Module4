const blogsApi = "http://localhost:8080/api/v1/Blogs";
const categoriesApi = "http://localhost:8080/api/v1/Categories";

function start() {
    getBlogs(renderBlogs);
    getCategories(renderCategories);
    handleCreateForm();
}

start();

function getBlogs(callback) {
    fetch(blogsApi)
        .then((response) => response.json())
        .then(callback);
}

function getCategories(callback) {
    fetch(categoriesApi)
        .then((response) => response.json())
        .then(callback);
}

function handleCreateBlog(data, callback) {
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    };
    fetch(blogsApi + "/insert", options)
        .then((response) => response.json())
        .then(callback);
}

function handleEditBlog(id, data, callback) {
    const options = {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    };

    fetch(blogsApi + "/" + id, options)
        .then((response) => response.json())
        .then(callback);
}

function handleDeleteBlog(id) {
    const options = {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        },
    };
    fetch(blogsApi + "/" + id, options)
        .then((response) => response.json())
        .then(() => {
            const blogItem = document.querySelector(".blog-" + id);
            if (blogItem) {
                blogItem.remove();
            }
        });
}
function renderBlogs(blogs) {
    const listBlogsBlock = document.querySelector("#list");
    const htmls = blogs.map((blog, index) => {
        return `
            <tr class="blog-${blog.id}">
                <td scope="col">${index + 1}</td>
                <td scope="col">${blog.id}</td>
                <td scope="col">${blog.title}</td>
                <td scope="col">${blog.author}</td>
                <td scope="col">${blog.postTime}</td>
                <td scope="col">${blog.category.type}</td>
                <td scope="col">${blog.content}</td>
                <td scope="col">
                    <button
                        type="button"
                        class="btn btn-primary"
                        data-bs-toggle="modal"
                        data-bs-target="#editModal"
                        onclick="handleEditForm(${blog.id})"
                    >
                        Edit
                    </button>
                    <button 
                    onclick="handleDeleteBlog(${blog.id})" class="btn btn-danger"
                    >
                        Delete
                    </button>
                </td>
            </tr>
        `;
    });
    listBlogsBlock.innerHTML = htmls.join("");
}

function renderCategories(categories) {
    const selectCategories = document.querySelectorAll("#categoryId");
    const htmls = categories.map((category) => {
        return `
            <option value="${category.id}">${category.type}</option>
        `;
    });

    selectCategories.forEach((select) => {
        select.innerHTML = htmls.join("");
    });
}

function handleCreateForm() {
    const createBtn = document.querySelector("#create");
    createBtn.onclick = function () {
        let title = document.querySelector("#title").value;
        let author = document.querySelector("#author").value;
        let postTime = document.querySelector("#postTime").value;
        let content = document.querySelector("#content").value;
        let categoryId = document.querySelector("#categoryId").value;
        const blog = {
            title: title,
            author: author,
            postTime: postTime,
            content: content,
            category: {
                id: categoryId,
            },
        };

        handleCreateBlog(blog, () => {
            getBlogs(renderBlogs);
        });

        $("#createModal").modal("hide");
    };
}

function handleEditForm(id) {
    let title = document.querySelector(".blog-" + id + " td:nth-child(3)");
    let author = document.querySelector(".blog-" + id + " td:nth-child(4)");
    let postTime = document.querySelector(".blog-" + id + " td:nth-child(5)");
    let content = document.querySelector(".blog-" + id + " td:nth-child(7)");

    document.querySelector('input[name="title"]').value = title.innerText;
    document.querySelector('input[name="author"]').value = author.innerText;
    document.querySelector('input[name="postTime"]').value = postTime.innerText;
    document.querySelector('textarea[name="content"]').value = content.innerText;

    const editBtn = document.querySelector("#edit");
    editBtn.onclick = function () {
        let title = document.querySelector('input[name="title"]').value;
        let author = document.querySelector('input[name="author"]').value;
        let postTime = document.querySelector('input[name="postTime"]').value;
        let categoryId = document.querySelector("#categoryId").value;
        let content = document.querySelector('textarea[name="content"]').value;

        console.log(categoryId);

        const formData = {
            title: title,
            author: author,
            postTime: postTime,
            content: content,
            category: {
                id: categoryId,
            },
        };

        handleEditBlog(id, formData, () => {
            getBlogs(renderBlogs);
        });

        $("#editModal").modal("hide");
    };
}

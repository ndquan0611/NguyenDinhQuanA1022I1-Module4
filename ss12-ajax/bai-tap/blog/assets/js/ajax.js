const blogsApi = "http://localhost:8080/api/v1/Blogs";
const categoriesApi = "http://localhost:8080/api/v1/Categories";

function start() {
    getBlogs(renderBlogs);
    getCategories(renderCategories);
    handleCreateForm();
}

start();

function getCategories(callback) {
    $.ajax({
        contentType: "application/json",
        type: "GET",
        dataType: "json",
        url: categoriesApi,
        success: callback,
    });
}

function getBlogs(callback) {
    $.ajax({
        contentType: "application/json",
        type: "GET",
        dataType: "json",
        url: blogsApi,
        success: callback,
        error: function () {
            console.log("loi");
        },
    });
}

function handleCreateBlog(data, callback) {
    $.ajax({
        contentType: "application/json",
        type: "POST",
        dataType: "json",
        data: JSON.stringify(data),
        url: blogsApi + "/insert",
        complete: callback,
        error: function () {
            console.log("thêm mới không thành công");
        },
    });
}

function handleEditBlog(id, data, callback) {
    $.ajax({
        contentType: "application/json",
        type: "PUT",
        dataType: "json",
        data: JSON.stringify(data),
        url: blogsApi + "/" + id,
        complete: callback,
        error: () => {
            console.log("loi");
        },
    });
}

function handleDeleteBlog(id) {
    $.ajax({
        contentType: "application/json",
        type: "DELETE",
        dataType: "json",
        url: blogsApi + "/" + id,
        complete: () => {
            const blogItem = document.querySelector(".blog-" + id);
            if (blogItem) {
                blogItem.remove();
            }
        },
    });
}

function renderBlogs(blogs) {
    const listBlogsBlock = document.querySelector("#list");
    const htmls = blogs.content.map((blog, index) => {
        return `
            <tr class="blog-${blog.id}">
                <td scope="col">${index + 1}</td>
                <td scope="col">${blog.id}</td>
                <td scope="col">${blog.title}</td>
                <td scope="col">${blog.author}</td>
                <td scope="col">${blog.postTime}</td>
                <td scope="col">${blog.category.type}</td>
                <td scope="col">${blog.content}</td>
                <td>
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
    const selectCreate = document.querySelector("#createCategory");
    const selectUpdate = document.querySelector("#updateCategory");
    const htmls = categories.map((category) => {
        return `
            <option value=${category.id}>${category.type}</option>
        `;
    });

    selectCreate.innerHTML = htmls.join("");
    selectUpdate.innerHTML = htmls.join("");
}

function handleCreateForm() {
    const createBtn = document.querySelector("#create");
    createBtn.onclick = function () {
        let title = $("#title").val();
        let author = document.querySelector("#author").value;
        let postTime = document.querySelector("#postTime").value;
        let content = document.querySelector("#content").value;
        let categoryId = document.querySelector("#createCategory").value;

        const formData = {
            title: title,
            author: author,
            postTime: postTime,
            category: {
                id: categoryId,
            },
            content: content,
        };

        handleCreateBlog(formData, () => {
            getBlogs(renderBlogs);
        });

        $("#createModal").modal("hide");
    };
}

function handleEditForm(id) {
    let title = $(".blog-" + id + " td:nth-child(3)");
    let author = $(".blog-" + id + " td:nth-child(4)");
    let postTime = $(".blog-" + id + " td:nth-child(5)");
    let categoryId = $(".blog-" + id + " td:nth-child(6)");
    let content = $(".blog-" + id + " td:nth-child(7)");

    document.querySelector('input[name="title"]').value = title.text();
    document.querySelector('input[name="author"]').value = author.text();
    document.querySelector('input[name="postTime"]').value = postTime.text();
    document.querySelector("select[id=updateCategory]" + " option").text = categoryId.text();
    document.querySelector('textarea[name="content"]').value = content.text();

    const editBtn = document.querySelector("#edit");
    editBtn.onclick = function () {
        let title = $('input[name="title"]').val();
        let author = $('input[name="author"]').val();
        let postTime = $('input[name="postTime"]').val();
        let categoryId = $("select[id=updateCategory]").val();
        let content = $('textarea[name="content"]').val();

        const formData = {
            title: title,
            author: author,
            postTime: postTime,
            category: {
                id: categoryId,
            },
            content: content,
        };

        console.log(formData);

        handleEditBlog(id, formData, () => {
            getBlogs(renderBlogs);
        });

        $("#editModal").modal("hide");
    };
}
